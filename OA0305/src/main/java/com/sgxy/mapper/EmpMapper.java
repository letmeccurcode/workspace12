package com.sgxy.mapper;

import com.sgxy.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {

    /**
     * 01-登录
     * @return
     */
    public Emp login(Emp emp);

    //    根据id更新用户头像
    void updatePhoto(@Param("id") Integer id, @Param("filename") String filename);


    boolean addEmp(Emp emp);
}
