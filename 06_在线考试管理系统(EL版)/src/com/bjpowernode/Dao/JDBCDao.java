package com.bjpowernode.Dao;

import com.bjpowernode.Utils.JDBCUtil;
import com.bjpowernode.entity.Question;
import com.bjpowernode.entity.Useru;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCDao {

    private JDBCUtil util = new JDBCUtil();
//用户注册方法
//    JDBC规范中，Connection的创建与销毁最浪费时间
    public int add(Useru user){
        String sql = "insert into useru(userName,password,sex,email) values(?,?,?,?)";
        int result = 0;
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
//    重载后的用户注册方法
    public int add(Useru user, HttpServletRequest request){
        String sql = "insert into useru(userName,password,sex,email) values(?,?,?,?)";
        int result = 0;
        PreparedStatement ps = util.createStatement(sql,request);
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
//用户查询方法
    public List findall(){
        String sql = "select * from useru";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List userList = new ArrayList();
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Useru user = new Useru(userId,userName,password,sex,email);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            util.close(rs);
        }
        return userList;
    }
//用户删除方法
    public int delete(String userId){
        String sql = "delete from useru where userId=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
//    用户登录方法
    public int login(String userName,String password){
        String sql = "select count(*) from useru where userName=? and password=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return result;
    }

}
