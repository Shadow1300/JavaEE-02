package jdbc;

import model.Homework;
import model.Student;
import model.SubmitHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.JdbcService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class StudentHomeworkJdbc {

    //看账号姓名是否对应
    public  String selectStudent(Student student) throws SQLException, ClassNotFoundException {

        //数据库执行语句
        String sqlString="select * from student"+" where student_id =\""+student.getStudent_id()+"\" and student_name=\""+student.getStudent_name()+"\"";

        System.out.println("aaa:"+sqlString);

        List<Student> list=new ArrayList<Student>();

        //创造链接
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            resultSet=statement.executeQuery(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }

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
    public  void addStudent(Student student) throws SQLException, ClassNotFoundException{
        //数据库执行语句
        String sqlString="insert into zy.student(student_id,student_name) values (\""+student.getStudent_id()+"\",\""+student.getStudent_name()+"\")";

        //创造链接
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        //ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            int resultSet=statement.executeUpdate(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }
    }

    //发布作业
    public  void addHomework(Homework homework) throws SQLException, ClassNotFoundException{

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String endtime=df.format(homework.getHomework_endtime());

        //数据库执行语句
        String sqlString="insert into zy.homework(homework_id,homework_requirement,homework_endtime) values (\""+homework.getHomework_id()+"\",\""+homework.getHomework_requirement()+"\",\""+endtime+"\")";

        System.out.println(sqlString);

        //创造链接
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        //ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            int resultSet=statement.executeUpdate(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }


    }

    //提交作业
    public  void submitHomework(SubmitHomework submitHomework) throws SQLException, ClassNotFoundException{

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String submit_time=df.format(submitHomework.getSubmit_time());

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");

        //数据库执行语句
        String sqlString="insert into zy.submit_homework(student_id,homework_id,homework_title,homework_content,submit_time,homework_endtime) values (\""+submitHomework.getStudent_id()+"\",\""+submitHomework.getHomework_id()+"\",\""+submitHomework.getHomework_title()+"\",\""+submitHomework.getHomework_content()+"\",\""+submit_time+"\",\""+jdbcService.selectEndtime(submitHomework.getHomework_id())+"\")";

        System.out.println(sqlString);

        //创造链接
       // ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        //ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            int resultSet=statement.executeUpdate(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }

    }

    //查询截止时间
    public  String selectEndtime(String homework_id) throws SQLException, ClassNotFoundException{

        //数据库执行语句
        String sqlString="select homework_endtime from zy.homework where homework_id=\""+homework_id+"\"";

        //创造链接
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            resultSet=statement.executeQuery(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }

        String out="";
        //获取执行结果
        while(resultSet.next()){
            out=resultSet.getString("homework_endtime");
        }
        return out;
    }

    //查询作业提交情况
    public  List<SubmitHomework> selectSubmit() throws SQLException, ClassNotFoundException {

        //数据库执行语句
        String sqlString="select * from submit_homework";

        List<SubmitHomework> list=new ArrayList<SubmitHomework>();

        //创造链接
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            resultSet=statement.executeQuery(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }

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
    public  List<Student> selectStudent() throws SQLException, ClassNotFoundException {
        //数据库执行语句
        String sqlString="select * from student";

        List<Student> list=new ArrayList<Student>();

        //创造链接
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            resultSet=statement.executeQuery(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }

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
    public  List<Homework> selectHomework() throws SQLException, ClassNotFoundException {
        //数据库执行语句
        String sqlString="select * from Homework";

        List<Homework> list=new ArrayList<Homework>();

        //创造链接
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        DatabasePool pool=(DatabasePool) applicationContext.getBean("pool");
        Connection connection=null;
        ResultSet resultSet = null;
        try{
            connection= pool.getHikariDataSource().getConnection();
            connection.setAutoCommit(false);
            //通过链接获取statement
            Statement statement=connection.createStatement();
            //statement做一些 增删改查
            resultSet=statement.executeQuery(sqlString);
            connection.commit();

        } catch (SQLException e) {
            System.out.println(e);
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1);
            }
        }finally{
            try {
                if(connection!=null){
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2);
            }
        }

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
