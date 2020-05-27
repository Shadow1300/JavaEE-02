package com.example.demo.controller;

import com.example.demo.core.request.HomeworkPageRequest;
import com.example.demo.core.response.DataResponse;
import com.example.demo.core.response.PageResponse;
import com.example.demo.db.model.Homework;
import com.example.demo.db.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final HomeworkService homeworkService;

    public ApiController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @RequestMapping("")
    public Homework addHomework(@RequestBody Homework homework){
        homeworkService.getMapper().save(homework);
        return null;
    }


    @RequestMapping("/homework/list")
    public PageResponse<Homework> homeworkList(@RequestBody HomeworkPageRequest request){
        int page=request.getPage();
        int size=request.getSize();

        PageResponse<Homework> response=new PageResponse<>();
        List<Homework> list = homeworkService.findall();
        Page<Homework> list1 = homeworkService.findall(page,size);

        Homework homework=Homework.builder().homework_id(request.getHomework_id()).build();


        Long homework_id=request.getHomework_id();
        Specification<Homework> specification=new Specification<Homework>() {

            @Override
            public Predicate toPredicate(Root<Homework> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList=new ArrayList<>();
                Predicate shPredicate=criteriaBuilder.greaterThan(root.get("homework_id"),homework_id);
                predicateList.add(shPredicate);

                criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

                Predicate[] predicates=new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        };

        //Page<Homework> list2 = homeworkService.findall(homework,page,size);
        //Page<Homework> list2 = homeworkService.findall(specification,page,size);
        Page<Homework> list2 = homeworkService.findall(specification,page,size);
        response.setData(list2.getContent());
        response.setTotal(list2.getTotalElements());

        return response;

    }

    @RequestMapping("/test")
    public Object test(){
        return "hello";
    }

}
