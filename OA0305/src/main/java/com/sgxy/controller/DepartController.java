package com.sgxy.controller;

import com.sgxy.pojo.Depart;
import com.sgxy.pojo.Message;
import com.sgxy.pojo.PageBean;
import com.sgxy.service.DepartService;
import com.sgxy.utils.ResultMessage;
import com.sgxy.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartController {

    @Autowired
    DepartService departService;

    /**
     * 1 分页查询部门信息
     *
     * @param pageNo
     * @param pageSize
     * @param m
     * @return
     */
    @RequestMapping("/queryDeptsByPage/{pageNo}/{pageSize}")
    public String queryDeptsByPage(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            Model m) {

        //获取部门的总记录数
        Integer count = departService.getTotalCount();
        //查询分页数据
        List<Depart> depts = departService.queryDepartByPage((pageNo - 1) * pageSize, pageSize);//
        PageBean<Depart> pb = new PageBean<>(pageNo, pageSize, count, depts);
        m.addAttribute("pb", pb);
        return "departlist";
    }


    /**
     * 2 同步新增部门信息
     *
     * @param d
     * @return
     */
    @RequestMapping("/addDepart")
    public String addDepart(Depart d) {
        boolean flag = departService.addDepart(d);
        System.out.println(flag ? "添加成功" : "添加失败");
        // 因为还没有实现查询功能 所以就暂时跳转到新增页面
        return "departadd";
    }

    /**
     * 3 异步新增部门信息
     *
     * @param d
     * @return
     */
    @ResponseBody
    @RequestMapping("/addDepartAjax")
    public Message addDepartAjax(Depart d) {
        boolean flag = departService.addDepart(d);
        Message m = new Message(flag ? 2 : 3, flag ? "添加成功" : "添加失败");
        //  因为还没有实现查询功能 所以就暂时跳转到新增页面
        return m;
    }


    /**
     * 4 查询所有部门信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/departall")
    public List<Depart> departAll() {
        List<Depart> depts = departService.queryAllDepart();
        return depts;
    }

    /**
     * 5 根据id删除部门记录
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deaprt_delete")
    public ResultMessage deaprt_delete(int id) {
        ResultMessage requestMessage = null;
        int count = departService.deleteDepart(id);
        if (count > 0) {
            requestMessage = new ResultMessage(200, "部门删除成功");
        } else {
            requestMessage = new ResultMessage(500, "部门删除失败");
        }
        return requestMessage;
    }
}
