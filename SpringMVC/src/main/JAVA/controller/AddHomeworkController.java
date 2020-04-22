package controller;

import jdbc.StudentHomeworkJdbc;
import model.Homework;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@org.springframework.stereotype.Controller
public class AddHomeworkController implements Controller{
    @Override
    @RequestMapping("/addHomework")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("addHomework.jsp");
        return mav;
    }

    @RequestMapping("/addHomeworkSuccess")
    public ModelAndView addStudentSuccess(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("addHomeworkSuccess.jsp");
        mav.addObject("message", "添加作业成功！");
        return mav;
    }

    @RequestMapping("/addHomeworkFault")
    public ModelAndView addStudentFault(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("addHomeworkFault.jsp");
        mav.addObject("message", "该作业序号已存在，不能重复发布");
        return mav;
    }

    @RequestMapping("/addHomework2")
    public ModelAndView addHomework(HttpServletRequest request,
                                    HttpServletResponse response) {

        Homework homework=new Homework();
        homework.setHomework_id(request.getParameter("homework_id"));
        homework.setHomework_requirement(request.getParameter("homework_requirement"));

        String homework_id=request.getParameter("homework_id");
        String homework_requirement=request.getParameter("homework_requirement");

        System.out.println("1"+homework_id);
        System.out.println("2"+homework_requirement);

        //不能为空
        if(homework_id.equals("")||homework_requirement.equals("")||request.getParameter("homework_endtime").equals("")){
            ModelAndView mav = new ModelAndView("redirect:/check");
            return mav;
        }
        else {
            //将String转为date形式
            String nowtime=request.getParameter("homework_endtime")+":00";
            nowtime=nowtime.substring(0,10)+" "+nowtime.substring(11);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d2 = null;
            try {
                d2 = sdf2.parse(nowtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            homework.setHomework_endtime(d2);

            //开始传
            try {
                ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
                JdbcService jdbcService=(JdbcService)applicationContext.getBean("jdbcService");
                jdbcService.addHomework(homework);
                ModelAndView mav = new ModelAndView("redirect:/addHomeworkSuccess");
                return mav;
            } catch (SQLException e) {
                ModelAndView mav = new ModelAndView("redirect:/addHomeworkFault");
                return mav;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
