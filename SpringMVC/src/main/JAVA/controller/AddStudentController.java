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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@org.springframework.stereotype.Controller
public class AddStudentController implements Controller{
    @Override
    @RequestMapping("/addStudent")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("addStudent.jsp");
        return mav;
    }

    @RequestMapping("/addStudentSuccess")
    public ModelAndView addStudentSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("AddStudentSuccess.jsp");
        mav.addObject("message", "添加学生成功！");
        return mav;
    }

    @RequestMapping("/addStudentFault")
    public ModelAndView addStudentFault(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("AddStudentFault.jsp");
        mav.addObject("message", "该学号已存在，不能重复添加");
        return mav;
    }

    @RequestMapping("/addStudent2")
    public ModelAndView addStudent(Student student) {

        String id=student.getStudent_id();
        String name=student.getStudent_name();

        //不能为空
        if(id.equals("")||name.equals("")){
            ModelAndView mav = new ModelAndView("redirect:/check");
            return mav;
        }
        else {
            try {
                ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
                JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");
                jdbcService.addStudent(student);
                ModelAndView mav = new ModelAndView("redirect:/addStudentSuccess");
                return mav;
            } catch (SQLException e) {
                ModelAndView mav = new ModelAndView("redirect:/addStudentFault");
                return mav;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
