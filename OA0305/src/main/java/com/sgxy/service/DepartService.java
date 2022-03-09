package com.sgxy.service;

import com.sgxy.pojo.Depart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartService {

    /**
     * 1 新增部门信息
     *
     * @param d
     * @return
     */
    boolean addDepart(Depart d);


    /**
     * 2 分页查询部门信息
     * select * from t_depart where del = 0 limit ?,?;
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Depart> queryDepartByPage(
            @Param("pageNo") Integer pageNo,
            @Param("pageSize") Integer pageSize);

    /**
     * 3 查询总记录条数
     *
     * @return
     */
    Integer getTotalCount();

    /**
     * 4 查询所有部门信息
     *
     * @return
     */
    List<Depart> queryAllDepart();

    /**
     * 5 根据id删除部门
     *
     * @param id
     * @return
     */
    int deleteDepart(int id);
}
