package com.sgxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {

    //双亲委派机制
    private Integer id;
    private Integer majorId;
    private String className;
    private String classDate;
    private String classTime;
    private String classAddress;
    private Integer classDelete;

}
