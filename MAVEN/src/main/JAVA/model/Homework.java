package model;

import java.util.Date;

public class Homework {
    private int id;
    private String homework_id;
    private String homework_requirement;
    private Date homework_endtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomework_id() {
        return homework_id;
    }

    public void setHomework_id(String homework_id) {
        this.homework_id = homework_id;
    }

    public String getHomework_requirement() {
        return homework_requirement;
    }

    public void setHomework_requirement(String homework_requirement) {
        this.homework_requirement = homework_requirement;
    }

    public Date getHomework_endtime() {
        return homework_endtime;
    }

    public void setHomework_endtime(Date homework_endtime) {
        this.homework_endtime = homework_endtime;
    }
}
