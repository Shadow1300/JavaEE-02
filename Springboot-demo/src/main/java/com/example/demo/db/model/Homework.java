package com.example.demo.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="homework")
public class Homework {
    @Id
    private Long id;
    private Long homework_id;
    private String homework_requirement;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-SS")
    private Date homework_endtime;

}
