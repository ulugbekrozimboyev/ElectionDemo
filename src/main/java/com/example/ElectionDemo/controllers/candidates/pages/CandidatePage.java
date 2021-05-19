package com.example.ElectionDemo.controllers.candidates.pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CandidatePage {
    @WebServlet(name = "AddCandidate", value = "/candidateAdd")
    public static class CandidateAdd extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidate/addCandidate.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @WebServlet(name = "Candidates", value = "/candidates")
    public static class CandidateList extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidate/candidateList.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    @WebServlet(name = "candidateUpdate", value = "/updateCandidate")
    public static class CandidateUpdate extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidate/updateCandidate.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
