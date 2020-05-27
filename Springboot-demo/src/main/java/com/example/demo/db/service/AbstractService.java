package com.example.demo.db.service;

import com.example.demo.db.mapper.BaseMapper;
import com.example.demo.db.model.Homework;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public abstract class AbstractService<E,PK>{
    protected abstract BaseMapper<E,PK> getMapper();

    public List<E> findall(){
        return getMapper().findAll();
    }

    public Page<E> findall(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<E> p= getMapper().findAll(pageable);
        return p;
    }
    public Page<E> findall(E e,int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        Example<E> example=Example.of(e);
        Page<E> p= getMapper().findAll(example,pageable);
        return p;
    }

    public Page<E> findall(Specification<E> specification, int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        Page<E> p= getMapper().findAll(specification,pageable);
        return p;
    }

    public List<E> findAll(Specification<E> specification) {
        List<E> list = getMapper().findAll(specification);
        return list;
    }
}
