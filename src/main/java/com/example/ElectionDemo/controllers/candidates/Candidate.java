package com.example.ElectionDemo.controllers.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.helpers.CandidateDaoHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/candidate")
public class Candidate extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        System.out.println(id);
        CandidateDao.delete(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        CandidateDto candidateDto = CandidateDaoHelper.getInstance().updateCandidateDto(params);
        CandidateDao.update(candidateDto);
        CandidateDao.save(candidateDto);

        resp.sendRedirect("/candidateList");
    }
}
