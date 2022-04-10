package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String questionId = request.getParameter("questionId");
           int result = 0;
           QuestionDao dao = new QuestionDao();
           result = dao.delete(questionId);

           request.setAttribute("key",result);
           request.getRequestDispatcher("/question_delete.jsp").forward(request,response);
    }
}
