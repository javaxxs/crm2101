package com.bjpowernode.Listener;

import com.bjpowernode.Utils.JDBCUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class oneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        JDBCUtil util = new JDBCUtil();
        Map map = new HashMap();
        for (int i =1;i<20;i++) {
            Connection con = util.getCon();
            System.out.println("在Http服务器启动时，创建Connection "+con);
            map.put(con,true);
        }
        ServletContext application = sce.getServletContext();
        application.setAttribute("key1",map);


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        ServletContext application = sce.getServletContext();
        Map map = (Map)application.getAttribute("key1");
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            Connection con = (Connection) it.next();
            if (con != null){
                System.out.println("兄弟们我 " + con +"先走一步，20年后还是一条好汉");
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
