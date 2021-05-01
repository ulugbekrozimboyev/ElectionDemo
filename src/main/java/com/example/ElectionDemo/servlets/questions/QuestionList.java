package com.example.ElectionDemo.servlets.questions;

import com.example.ElectionDemo.dao.MainDao;
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
@WebServlet(name = "QuestionsList", value = "/questions")
public class QuestionList extends HttpServlet {

    private String title;
    private List<QuestionDto> questionList;

    public void init() {
        title = "Get all questions";
        questionList = MainDao.getQuestionList();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("message", title);
        request.setAttribute("questionList", questionList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questions.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }
}
