package com.bjpowernode.controller;

import com.bjpowernode.Dao.JDBCDao;
import com.bjpowernode.entity.Useru;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Useru user = null;
        int result = 0;
        JDBCDao dao = new JDBCDao();
        PrintWriter out = null;

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");

        user = new Useru( null,userName,password,sex,email);
//       Date startData = new Date();
        result = dao.add(user,request);
//        Date endData = new Date();
//        System.out.println("创建用户的时间："+(endData.getTime()- startData.getTime())+"毫秒");

        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();

        if(result == 1){
            out.print("<font style='color:red;font-size:40'>用户注册成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40'>用户注册失败</font>");
        }

    }


}
