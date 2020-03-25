package org.example.javaee.class01.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.example.javaee.class01.jdbc.StudentHomeworkJdbc;
import org.example.javaee.class01.model.Homework;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addhomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置统一字符编码

        Homework homework=new Homework();
        homework.setHomework_id(req.getParameter("homework_id"));
        homework.setHomework_requirement(req.getParameter("homework_requirement"));

        //不能为空
        if(req.getParameter("homework_id").equals("")||req.getParameter("homework_requirement").equals("")||req.getParameter("homework_endtime").equals("")){
            resp.sendRedirect("check.jsp");
        }
        else {
            //将String转为date形式
            String nowtime=req.getParameter("homework_endtime")+":00";
            nowtime=nowtime.substring(0,10)+" "+nowtime.substring(11);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d2 = null;
            try {
                d2 = sdf2.parse(nowtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            homework.setHomework_endtime(d2);

            //开始传
            try {
                StudentHomeworkJdbc.addHomework(homework);
                resp.sendRedirect("addHomeworkSuccess.jsp");
            } catch (SQLException e) {
                resp.sendRedirect("addHomeworkFault.jsp");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}