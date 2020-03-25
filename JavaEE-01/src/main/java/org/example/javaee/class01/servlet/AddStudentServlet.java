package org.example.javaee.class01.servlet;


import org.example.javaee.class01.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.example.javaee.class01.jdbc.StudentHomeworkJdbc;

import java.sql.SQLException;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置统一字符编码

        Student student=new Student();
        student.setStudent_id(req.getParameter("student_id"));
        student.setStudent_name(req.getParameter("student_name"));

        //不能为空
        if(req.getParameter("student_id").equals("")||req.getParameter("student_name").equals("")){
            resp.sendRedirect("check.jsp");
        }
        else {
            try {
                StudentHomeworkJdbc.addStudent(student);
                resp.sendRedirect("AddStudentSuccess.jsp");
            } catch (SQLException e) {
                resp.sendRedirect("AddStudentFault.jsp");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
