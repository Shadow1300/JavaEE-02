package com.example.demo.db.service;

import com.example.demo.db.mapper.HomeworkMapper;
import com.example.demo.db.model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeworkService extends BaseService<Homework,Long,HomeworkMapper>{


}
