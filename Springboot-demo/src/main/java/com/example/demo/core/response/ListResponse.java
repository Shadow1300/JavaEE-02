package com.example.demo.core.response;

import lombok.Data;

import java.util.List;

@Data
public class ListResponse<T> extends BaseResponse{
    List<T> data;
}
