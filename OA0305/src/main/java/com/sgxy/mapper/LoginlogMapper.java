package com.sgxy.mapper;


import com.sgxy.pojo.Loginlog;

import java.util.List;

public interface LoginlogMapper {

    boolean addLoginLog(Loginlog log);

    //根据用户名查询登陆的信息
    List<Loginlog> queryLatestLog(String no);
}
