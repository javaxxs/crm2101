package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao = new QuestionDao();
        List list = dao.findRand();

        HttpSession session= request.getSession(false);
        session.setAttribute("key",list);

        request.getRequestDispatcher("/exam.jsp").forward(request,response);

    }
}
