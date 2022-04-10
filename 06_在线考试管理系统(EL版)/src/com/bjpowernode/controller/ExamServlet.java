package com.bjpowernode.controller;

import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ExamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int score = 0;
        HttpSession session = request.getSession(false);
        List<Question> list =(List) session.getAttribute("key");
        for(Question question:list){
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String userAnswer = request.getParameter("answer_"+questionId);
            if (answer.equals(userAnswer)){
                score+=25;
            }
        }
        request.setAttribute("key",score);

        request.getRequestDispatcher("/score.jsp").forward(request,response);
    }
}
