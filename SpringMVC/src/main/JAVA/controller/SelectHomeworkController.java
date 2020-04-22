package controller;

import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import service.JdbcService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class SelectHomeworkController implements Controller {
    @Override
    @RequestMapping("/selectHomework")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mav = new ModelAndView("selectHomework.jsp");
        try {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
            JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");
            List<Homework> list= jdbcService.selectHomework();
            mav.addObject("list", list);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mav;
    }

}
