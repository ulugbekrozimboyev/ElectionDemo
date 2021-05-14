package com.example.ElectionDemo.controllers.answers.pages;

import com.example.ElectionDemo.dao.AnswerDao;
import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.Answer;
import com.example.ElectionDemo.dto.QuestionAnswerDto;
import com.example.ElectionDemo.dto.StatisticsDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "statistics", value = "/statistics")
public class StatisticsPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("answers/statistics.jsp");
        requestDispatcher.forward(req, resp);
    }
}
