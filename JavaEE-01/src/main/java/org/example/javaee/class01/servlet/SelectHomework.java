package org.example.javaee.class01.servlet;

import org.example.javaee.class01.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.example.javaee.class01.jdbc.StudentHomeworkJdbc;

import java.sql.SQLException;
import java.util.List;

@WebServlet("/selecthomework")
public class SelectHomework extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Homework> list= StudentHomeworkJdbc.selectHomework();

            req.setAttribute("list",list);

            req.getRequestDispatcher("selectHomework.jsp").forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
