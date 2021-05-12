package com.example.ElectionDemo.controllers.questions;

import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.QuestionDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 3:41 PM
 */
@WebServlet(name = "questions", value = "/questions")
public class Questions extends HttpServlet {

    private String title;
    private List<QuestionDto> questions;

    public void init() {
        title = "Get all questions";
        questions = QuestionDao.findAll(getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("message", title);
        request.setAttribute("questionList", questions);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questions.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
