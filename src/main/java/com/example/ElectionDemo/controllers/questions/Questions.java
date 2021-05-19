package com.example.ElectionDemo.controllers.questions;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dao.QuestionDao;
import com.example.ElectionDemo.dto.CandidateDto;
import com.example.ElectionDemo.dto.QuestionDto;
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
import java.util.Objects;
import java.util.Optional;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 5/1/2021 3:41 PM
 */
@WebServlet(name = "questions", value = "/question")
public class Questions extends HttpServlet {
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null || (Objects.equals(id, ""))) {
            resp.getOutputStream().write(gson.toJson(QuestionDao.findAll(), new TypeToken<List<QuestionDto>>() {
            }.getType()).getBytes(StandardCharsets.UTF_8));
        } else {
            QuestionDto questionDto = QuestionDao.findById(Long.valueOf(id)).orElseThrow(
                    () -> new IllegalArgumentException("Question Not Found"));
            resp.getOutputStream().write(gson.toJson(questionDto, QuestionDto.class).getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDto questionDto = gson.fromJson(req.getReader(), QuestionDto.class);
        QuestionDao.update(questionDto);
        resp.sendRedirect("questions");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDto questionDto = gson.fromJson(req.getReader(), QuestionDto.class);
        QuestionDao.save(questionDto);
        resp.sendRedirect("questions");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        QuestionDao.delete(id);
    }
}
