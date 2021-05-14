package com.example.ElectionDemo.controllers.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.CandidateDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "Candidate", value = "/candidate")
public class Candidate extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (req.getParameter("id"));
        if(id == null || id.equals("")) {
            resp.getOutputStream().write(gson.toJson(CandidateDao.findAll(), new TypeToken<List<CandidateDto>>() {
            }.getType()).getBytes(StandardCharsets.UTF_8));
        } else {

            resp.getOutputStream().write(gson.toJson(CandidateDao.findById(Long.valueOf(id)).get(), CandidateDto.class).getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        CandidateDao.delete(id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateDto candidateDto = gson.fromJson(req.getReader(), CandidateDto.class);
        CandidateDao.save(candidateDto);
        resp.sendRedirect("candidates");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateDto candidateDto = gson.fromJson(req.getReader(), CandidateDto.class);
        CandidateDao.update(candidateDto);
        resp.sendRedirect("candidates");
    }
}
