package com.example.ElectionDemo.controllers.answers;

import com.example.ElectionDemo.dao.AnswerDao;
import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.AnswerDto;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.dto.QuestionAnswerDto;
import com.example.ElectionDemo.dto.StatisticsDto;
import com.example.ElectionDemo.helpers.AnswerDaoHelper;
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

@WebServlet(value = "/quiz/*")
public class Quiz extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getPathInfo() == null) {
            resp.getOutputStream().write(gson.toJson(new QuestionAnswerDto(QuestionDao.findAll(), com.example.ElectionDemo.dto.Answer.values()),
                    new TypeToken<QuestionAnswerDto>() {
                    }.getType()).getBytes(StandardCharsets.UTF_8));
            return;
        }
        String[] pathInfo = req.getPathInfo().split("/");
        if(pathInfo.length == 2) {
            if(pathInfo[1].equals("statistics")) {
                resp.getOutputStream().write(
                        gson.toJson(AnswerDao.getAnswerStatistics(CandidateDao.findAll(), QuestionDao.findAll()),
                                new TypeToken<List<StatisticsDto>>() {
                                }.getType()).getBytes(StandardCharsets.UTF_8));

            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = String.valueOf(req.getSession().getAttribute("username"));
        CandidateDto candidateDto = CandidateDao.findByFullName(username).get();
        List<AnswerDto> answerDtos = gson.fromJson(req.getReader(), new TypeToken<List<AnswerDto>>() {
        }.getType());
        answerDtos.forEach(answerDto -> answerDto.setUserId(candidateDto.getId()));
        AnswerDao.save(answerDtos);
        resp.sendRedirect("/");
    }
}
