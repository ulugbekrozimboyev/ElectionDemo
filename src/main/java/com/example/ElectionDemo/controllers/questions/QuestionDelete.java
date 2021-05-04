package com.example.ElectionDemo.controllers.questions;

import com.example.ElectionDemo.dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "questionDelete", value = "/questionDelete")
public class QuestionDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        QuestionDao.delete(id);

        response.sendRedirect("questions");
    }

}
