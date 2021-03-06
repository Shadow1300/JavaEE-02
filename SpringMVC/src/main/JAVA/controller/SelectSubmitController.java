package controller;

import jdbc.StudentHomeworkJdbc;
import model.Student;
import model.SubmitHomework;
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
public class SelectSubmitController implements Controller {
    @Override
    @RequestMapping("/selectSubmit")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mav = new ModelAndView("selectSubmit.jsp");
        try {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
            JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");
            List<SubmitHomework> list= jdbcService.selectSubmit();
            mav.addObject("list", list);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mav;
    }
}
