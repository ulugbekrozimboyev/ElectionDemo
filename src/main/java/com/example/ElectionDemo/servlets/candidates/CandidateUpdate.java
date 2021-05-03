package com.example.ElectionDemo.servlets.candidates;

import com.example.ElectionDemo.dao.CandidateDao;
import com.example.ElectionDemo.dto.CandidateDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "candidateUpdate", urlPatterns = "/updateCandidate")
public class CandidateUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        CandidateDto candidateDto = CandidateDao.findById(id).get();
        request.setAttribute("candidate", candidateDto);
        request.setAttribute("title", "Update Candidate ID#" + id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidate/updateCandidate.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        CandidateDto candidateDto = new CandidateDto();
        HashMap<String, String> moreInfo = new HashMap<>();
        for (String name : map.keySet()) {
            if(name.equals("id")) {
                candidateDto.setId(Long.valueOf(map.get(name)[0]));
            }
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
        CandidateDao.update(candidateDto);
        resp.sendRedirect("/CandidateList");
    }
}
