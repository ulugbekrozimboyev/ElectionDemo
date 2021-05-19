package com.example.ElectionDemo.controllers.questions.pages;

import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.QuestionDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionPage {
    @WebServlet(name = "questionAdd", value = "/questionAdd")
    public static class QuestionAdd extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questionAdd.jsp");
            requestDispatcher.forward(request, response);
        }

    }
    @WebServlet(name = "Questions", value = "/questions")
    public static class QuestionList extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questions.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    @WebServlet(name = "questionUpdate", value = "/questionUpdate")
    public static class QuestionUpdate extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questionUpdate.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
