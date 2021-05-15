package com.example.ElectionDemo.controllers.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dao.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "candidateDelete", urlPatterns = "/candidateDelete")
public class CandidateDelete extends HttpServlet {
    private final CandidateDao dao;

    public CandidateDelete() {
        this.dao = DaoFactory.getInstance().getCandidateDao();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        dao.delete(Long.valueOf(params.get("id")[0]));

        resp.sendRedirect("candidates");
    }
}
