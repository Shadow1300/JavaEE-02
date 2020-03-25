package org.example.javaee.class01.jdbc;

import org.example.javaee.class01.model.Homework;
import org.example.javaee.class01.model.Student;
import org.example.javaee.class01.model.SubmitHomework;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class StudentHomeworkJdbc {

    //看账号姓名是否对应
    public static String selectStudent(Student student) throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT";

        String driverName="com.mysql.jdbc.Driver";

        //数据库执行语句
        String sqlString="select * from student"+" where student_id =\""+student.getStudent_id()+"\" and student_name=\""+student.getStudent_name()+"\"";

        System.out.println("aaa:"+sqlString);
        //加载驱动
        Class.forName(driverName);

        List<Student> list=new ArrayList<Student>();

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        ResultSet resultSet=statement.executeQuery(sqlString);

        //获取执行结果
        if(resultSet.next()){
           //进入页面
            String check="success";
            System.out.println(1111);
            return check;
        }
        else {
            String check="wrong";
            System.out.println("2222");
            return check;
        }
    }

    //添加学生
    public static void addStudent(Student student) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true";

        String driverName="com.mysql.jdbc.Driver";

        //数据库执行语句
        String sqlString="insert into zy.student(student_id,student_name) values (\""+student.getStudent_id()+"\",\""+student.getStudent_name()+"\")";

        //加载驱动
        Class.forName(driverName);

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        int resultSet=statement.executeUpdate(sqlString);
    }

    //发布作业
    public static void addHomework(Homework homework) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true";

        String driverName="com.mysql.jdbc.Driver";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String endtime=df.format(homework.getHomework_endtime());

        //数据库执行语句
        String sqlString="insert into zy.homework(homework_id,homework_requirement,homework_endtime) values (\""+homework.getHomework_id()+"\",\""+homework.getHomework_requirement()+"\",\""+endtime+"\")";

        System.out.println(sqlString);

        //加载驱动
        Class.forName(driverName);

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        int resultSet=statement.executeUpdate(sqlString);
    }

    //提交作业
    public static void submitHomework(SubmitHomework submitHomework) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true";

        String driverName="com.mysql.jdbc.Driver";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String submit_time=df.format(submitHomework.getSubmit_time());

        //数据库执行语句
        String sqlString="insert into zy.submit_homework(student_id,homework_id,homework_title,homework_content,submit_time,homework_endtime) values (\""+submitHomework.getStudent_id()+"\",\""+submitHomework.getHomework_id()+"\",\""+submitHomework.getHomework_title()+"\",\""+submitHomework.getHomework_content()+"\",\""+submit_time+"\",\""+StudentHomeworkJdbc.selectEndtime(submitHomework.getHomework_id())+"\")";

        System.out.println(sqlString);

        //加载驱动
        Class.forName(driverName);

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        int resultSet=statement.executeUpdate(sqlString);
    }

    //查询截止时间
    public static String selectEndtime(String homework_id) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true";

        String driverName="com.mysql.jdbc.Driver";

        //数据库执行语句
        String sqlString="select homework_endtime from zy.homework where homework_id=\""+homework_id+"\"";

        //加载驱动
        Class.forName(driverName);

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        ResultSet resultSet=statement.executeQuery(sqlString);

        String out="";

        //获取执行结果
        while(resultSet.next()){
            out=resultSet.getString("homework_endtime");
        }
        return out;
    }

    //查询作业提交情况
    public static List<SubmitHomework> selectSubmit() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true";

        String driverName="com.mysql.jdbc.Driver";

        //数据库执行语句
        String sqlString="select * from submit_homework";

        //加载驱动
        Class.forName(driverName);

        List<SubmitHomework> list=new ArrayList<SubmitHomework>();

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        ResultSet resultSet=statement.executeQuery(sqlString);

        //获取执行结果
        while(resultSet.next()){
            SubmitHomework submitHomework=new SubmitHomework();

            submitHomework.setId(resultSet.getInt("id"));
            submitHomework.setStudent_id(resultSet.getString("student_id"));
            submitHomework.setHomework_id(resultSet.getString("homework_id"));
            submitHomework.setHomework_title(resultSet.getString("homework_title"));
            submitHomework.setHomework_content(resultSet.getString("homework_content"));
            submitHomework.setSubmit_time(resultSet.getTimestamp("submit_time"));
            submitHomework.setHomework_endtime(resultSet.getTimestamp("homework_endtime"));

            list.add(submitHomework);
        }

        return list;
    }

    //查看学生
    public static List<Student> selectStudent() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true";

        String driverName="com.mysql.jdbc.Driver";

        //数据库执行语句
        String sqlString="select * from student";

        //加载驱动
        Class.forName(driverName);

        List<Student> list=new ArrayList<Student>();

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        ResultSet resultSet=statement.executeQuery(sqlString);

        //获取执行结果
        while(resultSet.next()){
            Student student=new Student();

            student.setId(resultSet.getInt("id"));
            student.setStudent_id(resultSet.getString("student_id"));
            student.setStudent_name(resultSet.getString("student_name"));

            list.add(student);
        }

        return list;
    }

    //查看作业要求
    public static List<Homework> selectHomework() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true";

        String driverName="com.mysql.jdbc.Driver";

        //数据库执行语句
        String sqlString="select * from Homework";

        //加载驱动
        Class.forName(driverName);

        List<Homework> list=new ArrayList<Homework>();

        //创造链接
        Connection connection= DriverManager.getConnection(url,"root","zhangying");

        //通过链接获取statement
        Statement statement=connection.createStatement();

        //statement做一些 增删改查
        ResultSet resultSet=statement.executeQuery(sqlString);

        //获取执行结果
        while(resultSet.next()){
            Homework homework=new Homework();
            homework.setId(resultSet.getInt("id"));
            homework.setHomework_id(resultSet.getString("homework_id"));
            homework.setHomework_requirement(resultSet.getString("homework_requirement"));
            homework.setHomework_endtime(resultSet.getTimestamp("homework_endtime"));
            list.add(homework);
        }
        return list;
    }

}
