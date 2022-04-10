package com.bjpowernode.controller;

import com.bjpowernode.Dao.JDBCDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId;
        JDBCDao dao = new JDBCDao();
        int result = 0;
        PrintWriter out;

        userId = request.getParameter("userId");

        result = dao.delete(userId);
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();

        if(result == 1){
            out.print("<font style='color:red;font-size:40'>用户信息删除成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40'>用户信息删除失败</font>");
        }
    }


}