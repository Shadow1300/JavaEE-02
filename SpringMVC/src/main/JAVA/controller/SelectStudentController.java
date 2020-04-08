package controller;

import jdbc.StudentHomeworkJdbc;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class SelectStudentController implements Controller {
    @Override
    @RequestMapping("/selectStudent")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mav = new ModelAndView("selectStudent.jsp");
        try {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
            StudentHomeworkJdbc jdbc=(StudentHomeworkJdbc)applicationContext.getBean("JDBC");
            List<Student> list= jdbc.selectStudent();
            mav.addObject("list", list);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mav;
    }

}
