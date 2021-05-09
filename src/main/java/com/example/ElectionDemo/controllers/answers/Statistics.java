package com.example.ElectionDemo.controllers.answers;

import com.example.ElectionDemo.controllers.candidates.Candidate;
import com.example.ElectionDemo.dao.AnswerDao;
import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.Answer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "statistics", value = "/statistics")
public class Statistics extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("statistics", AnswerDao.getAnswerStatistics(CandidateDao.findAll(), QuestionDao.findAll()));
        System.out.println(AnswerDao.getAnswerStatistics(CandidateDao.findAll(), QuestionDao.findAll()));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("answers/statistics.jsp");
        requestDispatcher.forward(req, resp);
    }
}
