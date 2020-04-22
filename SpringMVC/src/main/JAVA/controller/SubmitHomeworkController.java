package controller;

import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.Student;
import model.SubmitHomework;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Controller
public class SubmitHomeworkController implements Controller{
    @Override
    @RequestMapping("/submitHomework")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("submitHomework.jsp");
        return mav;
    }

    @RequestMapping("/submitHomeworkSuccess")
    public ModelAndView addStudentSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("submitHomeworkSuccess.jsp");
        mav.addObject("message", "作业提交成功！！");
        return mav;
    }

    @RequestMapping("/submitHomeworkFault")
    public ModelAndView addStudentFault(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("submitHomeworkFault.jsp");
        mav.addObject("message", "作业提交失败,学号不存在或作业号不存在");
        return mav;
    }

    @RequestMapping("/submitHomework2")
    public ModelAndView addHomework(HttpServletRequest request,
                                    HttpServletResponse response) {

        SubmitHomework submitHomework=new SubmitHomework();

        //获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String nowtime=df.format(new Date());

        submitHomework.setStudent_id(request.getParameter("student_id"));
        submitHomework.setHomework_id(request.getParameter("homework_id"));
        submitHomework.setHomework_title(request.getParameter("homework_title"));
        submitHomework.setHomework_content(request.getParameter("homework_content"));

        //给定模式(这里给定的模式须与给定日期字符串格式匹配)，将String转为Date
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = null;
        try {
            d2 = sdf2.parse(nowtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //赋值时间
        submitHomework.setSubmit_time(d2);

        //不能为空
        if(request.getParameter("student_id").equals("")||request.getParameter("homework_id").equals("")){
            ModelAndView mav = new ModelAndView("redirect:/check");
            return mav;
        }
        else {
            try {
                ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
                JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");
                jdbcService.submitHomework(submitHomework);
                ModelAndView mav = new ModelAndView("redirect:/submitHomeworkSuccess");
                return mav;
            } catch (SQLException e) {
                ModelAndView mav = new ModelAndView("redirect:/submitHomeworkFault");
                return mav;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
