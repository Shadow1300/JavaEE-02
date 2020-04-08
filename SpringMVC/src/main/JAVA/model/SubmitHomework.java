package model;

import java.util.Date;

public class SubmitHomework {
    private int id;
    private String student_id;
    private String homework_id;
    private String homework_title;
    private String homework_content;
    private Date submit_time;
    private Date homework_endtime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(String homework_id) {
        this.homework_id = homework_id;
    }

    public String getHomework_title() {
        return homework_title;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public String getHomework_content() {
        return homework_content;
    }

    public void setHomework_content(String homework_content) {
        this.homework_content = homework_content;
    }

    public Date getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(Date submit_time) {
        this.submit_time = submit_time;
    }

    public Date getHomework_endtime() {
        return homework_endtime;
    }

    public void setHomework_endtime(Date homework_endtime) {
        this.homework_endtime = homework_endtime;
    }
}
