package com.example.ElectionDemo.controllers.questions;

import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.QuestionDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "questionAdd", value = "/questionAdd")
public class QuestionAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questionAdd.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        QuestionDto questionDto = new QuestionDto();
        questionDto.setTitle(title);
        QuestionDao.save(questionDto);

        response.sendRedirect("questions");
    }
}
