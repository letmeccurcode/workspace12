package com.sgxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String no;
    private String name;
    private String sex;
    private String birthday;
    private String cardno;
    private String school;
    private String education;
    private Integer classId;
    private Integer flag;//1 0

//    private String lock_status;

    private String email;
    private String qq;
    private String phone;
    private String createdate;
    private String photo;
    private Integer del;//1 0

//    private String del_status;

    private Class c;


}
