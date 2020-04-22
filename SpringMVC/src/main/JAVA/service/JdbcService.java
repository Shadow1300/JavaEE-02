package service;

import jdbc.DatabasePool;
import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.Student;
import model.SubmitHomework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcService {
    public void aa(){
        System.out.println("111");
    }
    public void bb(){
        System.out.println("222");
    }
    //ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
   // StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");

    //查看已发布的作业
    public List<Homework> selectHomework() throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        List<Homework> list= jdbc.selectHomework();
        System.out.println("查看已发布作业");
        return list;
    }

    //查看学生
    public List<Student> selectStudent() throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        List<Student> list= jdbc.selectStudent();
        System.out.println("查看学生名单");
        return list;
    }

    //查看作业提交
    public  List<SubmitHomework> selectSubmit() throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        List<SubmitHomework> list= jdbc.selectSubmit();
        System.out.println("查看作业提交情况");
        return list;
    }
    //查询截止时间
    public  String selectEndtime(String homework_id) throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        String time=jdbc.selectEndtime(homework_id);
        System.out.println("查询作业截止时间");
        return time;
    }

    //提交作业
    public  void submitHomework(SubmitHomework submitHomework)throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        jdbc.submitHomework(submitHomework);
        System.out.println("提交作业");
    }

    //发布作业
    public  void addHomework(Homework homework)throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        jdbc.addHomework(homework);
        System.out.println("发布作业");
    }

    //添加学生
    public  void addStudent(Student student) throws SQLException, ClassNotFoundException{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        jdbc.addStudent(student);
        System.out.println("添加学生");
    }

    //查看学号姓名是否对应
    public  String selectStudent(Student student) throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        String back=jdbc.selectStudent(student);
        System.out.println("查看学号姓名是否对应");
        return back;
    }



}
