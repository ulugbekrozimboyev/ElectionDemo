package com.example.ElectionDemo.controllers.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.helpers.CandidateDaoHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "candidateUpdate", urlPatterns = "/updateCandidate")
public class CandidateUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));

        CandidateDto candidateDto = CandidateDao.findById(id).get();
        request.setAttribute("candidate", candidateDto);
        request.setAttribute("title", "Update Candidate ID#" + id);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidate/updateCandidate.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        CandidateDto candidateDto = CandidateDaoHelper.getInstance().updateCandidateDto(params);
        CandidateDao.update(candidateDto);

        resp.sendRedirect("candidates");
    }
}
