package com.example.ElectionDemo.servlets.questions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 3:41 PM
 */
@WebServlet(name = "QuestionsList", value = "/questions")
public class QuestionList extends HttpServlet {

    private String message;

    public void init() {
        message = "Get all questions";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("questions/questions.jsp");
    }

    public void destroy() {
    }
}
