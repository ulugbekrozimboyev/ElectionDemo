package com.example.ElectionDemo.servlets.auth;

import com.example.ElectionDemo.helpers.AuthHelper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("auth/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(AuthHelper.isAllowed(uname, pword)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", uname);

            request.setAttribute("username", uname);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {

            request.setAttribute("message", "Login or password is not correct !");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("auth/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
