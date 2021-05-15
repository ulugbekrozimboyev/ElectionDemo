package com.example.ElectionDemo.controllers.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dao.DaoFactory;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.helpers.CandidateDaoHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet(urlPatterns = "/candidate")
public class Candidate extends HttpServlet {

    private final CandidateDao dao;

    public Candidate() {
        this.dao = DaoFactory.getInstance().getCandidateDao();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        System.out.println(id);
        dao.delete(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        Optional<CandidateDto> currentCandidate = dao.findById(Long.valueOf(params.get("id")[0]));
        CandidateDto updatedCandidate = CandidateDaoHelper.getInstance().updateCandidateDto(currentCandidate.get(), params);
        dao.save(updatedCandidate);

        resp.sendRedirect("candidates");
    }
}
