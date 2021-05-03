package com.example.ElectionDemo.controllers.questions;

import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.QuestionDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "QuestionUpdate", value = "/questionUpdate")
public class QuestionUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Optional<QuestionDto> optional = QuestionDao.findById(id);
        if(!optional.isPresent()){
            response.sendRedirect("questions");
        }

        request.setAttribute("question", optional.get());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("questions/questionUpdate.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(id);
        questionDto.setTitle(title);
        QuestionDao.update(questionDto);

        response.sendRedirect("questions");
    }
}
