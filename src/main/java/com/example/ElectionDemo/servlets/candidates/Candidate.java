package com.example.ElectionDemo.servlets.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.CandidateDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(urlPatterns = "/candidate")
public class Candidate extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        System.out.println(id);
        CandidateDao.delete(id);
//        response.sendRedirect("/candidate/candidates.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        CandidateDto candidateDto = new CandidateDto();
        HashMap<String, String> moreInfo = new HashMap<>();
        for (String name : map.keySet()) {
            if(name.equals("fullName")) {
                candidateDto.setFullName(map.get(name)[0]);
            }
            if(name.equals("currentJob")) {
                candidateDto.setCurrentJob(map.get(name)[0]);
            }
            if(name.equals("about")) {
                candidateDto.setAbout(map.get(name)[0]);
            }

            if(name.contains("key-")) {
                moreInfo.put(map.get(name)[0], map.get("value-" + name.substring(name.lastIndexOf("-") + 1))[0]);
            }
        }
        candidateDto.setMoreInformation(moreInfo);
        CandidateDao.save(candidateDto);
        resp.sendRedirect("/CandidateList");
    }
}
