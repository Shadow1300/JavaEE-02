package controller;

import jdbc.StudentHomeworkJdbc;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import service.JdbcService;

import java.sql.SQLException;

@org.springframework.stereotype.Controller
public class HelloController implements Controller {

    @RequestMapping("/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("aa.jsp");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    @RequestMapping("/check")
    public ModelAndView check(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("check.jsp");
        mav.addObject("message", "请填写完整，不能为空");
        return mav;
    }

    @RequestMapping("/checkwrong")
    public ModelAndView checkwrong(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("check.jsp");
        mav.addObject("message", "学号与姓名不对应或该学生不存在，登录失败");
        return mav;
    }


    @RequestMapping("/load")
    public ModelAndView load(Student student) {

        String id=student.getStudent_id();
        String name=student.getStudent_name();

        System.out.println(id);
        System.out.println(name);

        //不能为空
        if(id.equals("")||name.equals("")){
            ModelAndView mav = new ModelAndView("redirect:/check");
            return mav;
        }
        else{
            try {
                ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
                JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");
                String answer= jdbcService.selectStudent(student);
                if(answer.equals("success")){
                    ModelAndView mav = new ModelAndView("redirect:/Main");
                    return mav;
                }
                else {
                    ModelAndView mav = new ModelAndView("redirect:/checkwrong");
                    return mav;
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return null;
    }

}
