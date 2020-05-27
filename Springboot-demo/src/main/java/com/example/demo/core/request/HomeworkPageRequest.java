package com.example.demo.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class HomeworkPageRequest extends PageRequest{

    private Long homework_id;
}
