package test;

import jdbc.StudentHomeworkJdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
        
        System.out.println(jdbc.toString());
    }
}
