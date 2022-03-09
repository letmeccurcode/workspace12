package com.sgxy.service;

import com.sgxy.pojo.Emp;

public interface EmpService {

    /**
     * 01-登录
     * @return
     */
    public Emp login(Emp emp);

    void updatePhoto(Integer id, String filename);

    boolean addEmp(Emp emp);

}
