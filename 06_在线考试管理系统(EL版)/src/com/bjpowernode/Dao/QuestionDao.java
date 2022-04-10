package com.bjpowernode.Dao;

import com.bjpowernode.Utils.JDBCUtil;
import com.bjpowernode.entity.Question;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private JDBCUtil util = new JDBCUtil();

    //    添加试题方法
    public int add(Question question){
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
        int result = 0;
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    //    重载后的添加试题方法
    public int add(Question question, HttpServletRequest request){
        String sql = "insert into queation(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
        int result = 0;
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(request);
        }
        return result;
    }
//    查询试题的方法
    public List findall(){
        List list = new ArrayList();
        String sql = "select * from queation";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           util.close(rs);
        }
        return list;
    }
//    删除试题的方法
    public int delete(String questionId){
       String sql = "delete from queation where questionId=?";
       PreparedStatement ps = util.createStatement(sql);
       int result = 0;
        try {
            ps.setString(1,questionId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    public Question findByid(String questionIds){
        Question question = null;
        String sql = "select * from queation where questionId=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,questionIds);
            rs = ps.executeQuery();
            while(rs.next()) {
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question = new Question(questionId, title, optionA, optionB, optionC, optionD, answer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return question;
    }
    //    更新试题的方法
    public int update(Question question){
        int result = 0;
        String sql = "update queation set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setString (1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setString(7, String.valueOf(question.getQuestionId()));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }

        return result;
    }
//考试时随机抽取4道题
    public List findRand(){
        List list = new ArrayList();
        String sql = "select * from queation order by rand() desc limit 0,4";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                Integer questionId = rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question = new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(question);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return list;
    }
}
