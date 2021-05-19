package com.example.ElectionDemo.controllers.answers.pages;

import com.example.ElectionDemo.dao.AnswerDao;
import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.AnswerDto;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.helpers.AnswerDaoHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class QuizPage {
    @WebServlet(name = "Answer", value = "/answer")
    public static class AnswerPage extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("answers/answer.jsp");
            requestDispatcher.forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Map<String, String[]> params = req.getParameterMap();
            String username = String.valueOf(req.getSession().getAttribute("username"));
            CandidateDto candidateDto = CandidateDao.findByFullName(username).get();
            List<AnswerDto> answerDtos = AnswerDaoHelper.getInstance().getUserAnswerDtos(params, candidateDto.getId());
            AnswerDao.save(answerDtos);
            resp.sendRedirect("/");
        }
    }

    @WebServlet(name = "statistics", value = "/statistics")
    public static class StatisticsPage extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("answers/statistics.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
