package com.sgxy.service.impl;


//一定要加@Service

import com.sgxy.mapper.LoginlogMapper;
import com.sgxy.pojo.Loginlog;
import com.sgxy.service.LoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginlogServiceImpl implements LoginlogService {

    @Autowired
    LoginlogMapper lm;

    @Override
    public boolean addLoginLog(Loginlog log) {
        System.out.println(log);
        boolean b = lm.addLoginLog(log);
        System.out.println(b + "-----");
        return b;
    }

    @Override
    public List<Loginlog> queryLatestLog(String no) {
        return lm.queryLatestLog(no);
    }
}
