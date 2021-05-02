package com.example.ElectionDemo.servlets.candidates;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/candidateAdd")
public class CandidateAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Add Candidate");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidate/addCandidate.jsp");
        requestDispatcher.forward(request, response);
    }
}