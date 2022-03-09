package com.sgxy.service.impl;

import com.sgxy.mapper.EmpMapper;
import com.sgxy.pojo.Emp;
import com.sgxy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpServiceImpl implements EmpService {

    //    @Resource
    @Autowired
    EmpMapper empMapper;

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }

    @Override
    public void updatePhoto(Integer id, String filename) {
        empMapper.updatePhoto(id, filename);
    }

    @Override
    public boolean addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }
}
