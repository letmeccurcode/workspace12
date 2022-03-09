package com.sgxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Alias() 手动指定别名
public class Emp {

    private Integer id;
    private String no;
    private String pass;
    private String name;
    private Integer did;
    private Integer flag;
    private String sex;
    private String email;
    private String qq;
    private String phone;
    private String createdate;
    private String photo;
    private Integer del;

    //    记录登录日志
    private String ip;
    private String city;

    //一对一映射关系 查询员工对应的部门信息
    private Depart d;
}
