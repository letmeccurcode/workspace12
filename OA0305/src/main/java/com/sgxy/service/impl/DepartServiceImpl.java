package com.sgxy.service.impl;


import com.sgxy.mapper.DepartMapper;
import com.sgxy.pojo.Depart;
import com.sgxy.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartMapper departMapper;

    @Override
    public boolean addDepart(Depart d) {
        return departMapper.addDepart(d);
    }

    @Override
    public List<Depart> queryDepartByPage(Integer pageNo, Integer pageSize) {
        return departMapper.queryDepartByPage(pageNo, pageSize);
    }

    @Override
    public Integer getTotalCount() {
        return departMapper.getTotalCount();
    }

    @Override
    public List<Depart> queryAllDepart() {
        return departMapper.queryAllDepart();
    }

    @Override
    public int deleteDepart(int id) {
        return departMapper.deleteDepart(id);
    }
}
