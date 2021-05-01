package com.example.ElectionDemo.servlets.questions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 3:41 PM
 */
@WebServlet(name = "QuestionsList", value = "/questions")
public class QuestionList extends HttpServlet {

    private String message;
    private List<String> questionList;

    public void init() {
        message = "Get all questions";
        questionList = new ArrayList<>();
        questionList.add(" This is a question one");
        questionList.add(" This is a question two");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("message", message);
        request.setAttribute("questionList", questionList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questions.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
