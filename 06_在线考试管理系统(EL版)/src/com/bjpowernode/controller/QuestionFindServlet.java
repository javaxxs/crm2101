package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     QuestionDao dao = new QuestionDao();
     List list = new ArrayList();
     list = dao.findall();

     request.setAttribute("key",list);
     request.getRequestDispatcher("/info_2.jsp").forward(request,response);

    }
}
