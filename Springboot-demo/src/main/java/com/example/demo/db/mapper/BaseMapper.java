package com.example.demo.db.mapper;

import com.example.demo.db.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseMapper<E,PK> extends JpaRepository<E,PK>, JpaSpecificationExecutor<E> {
}
