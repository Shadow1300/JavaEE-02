package test;

import aspect.TestAspect;
import jdbc.StudentHomeworkJdbc;
import model.Homework;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import service.JdbcService;

import java.sql.SQLException;
import java.util.List;
//@ComponentScan("*")

@EnableAspectJAutoProxy
public class TestSpring {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TestSpring.class);

        //JdbcService jdbcService=context.getBean("jdbcService",JdbcService.class);
        //jdbcService.getById(10L);

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
      //  TestAspect testAspect=(TestAspect)applicationContext.getBean("testAspect");
       // System.out.println(testAspect.toString());
        JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");
        jdbcService.aa();
        jdbcService.bb();
        List<Homework> list= jdbcService.selectHomework();
       // System.out.println("11111111");


         //System.out.println(jdbc.toString());
    }

}
