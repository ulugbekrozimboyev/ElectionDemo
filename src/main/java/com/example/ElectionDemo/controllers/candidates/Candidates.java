package com.example.ElectionDemo.controllers.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dao.DaoFactory;
import com.example.ElectionDemo.dto.CandidateDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "candidates", value = "/candidates")
public class Candidates extends HttpServlet {
    private final CandidateDao dao;
    private List<CandidateDto> candidates;

    public Candidates() {
        this.dao = DaoFactory.getInstance().getCandidateDao();
    }

    @Override
    public void init() throws ServletException {
        candidates = dao.findAll();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("candidates", candidates);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidate/candidates.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
