package org.example.javaee.class01.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.example.javaee.class01.jdbc.StudentHomeworkJdbc;
import org.example.javaee.class01.model.SubmitHomework;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/submit")
public class SubmitHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置统一字符编码

        SubmitHomework submitHomework=new SubmitHomework();

        //获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String nowtime=df.format(new Date());

        submitHomework.setStudent_id(req.getParameter("student_id"));
        submitHomework.setHomework_id(req.getParameter("homework_id"));
        submitHomework.setHomework_title(req.getParameter("homework_title"));
        submitHomework.setHomework_content(req.getParameter("homework_content"));

        //给定模式(这里给定的模式须与给定日期字符串格式匹配)，将String转为Date
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = null;
        try {
            d2 = sdf2.parse(nowtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //赋值时间
        submitHomework.setSubmit_time(d2);

        //不能为空
        if(req.getParameter("student_id").equals("")||req.getParameter("homework_id").equals("")){
            resp.sendRedirect("check.jsp");
        }
        else {
            try {
                StudentHomeworkJdbc.submitHomework(submitHomework);
                resp.sendRedirect("submitHomeworkSuccess.jsp");
            } catch (SQLException e) {
                resp.sendRedirect("submitHomeworkFault.jsp");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
