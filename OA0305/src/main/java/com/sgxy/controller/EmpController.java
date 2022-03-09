package com.sgxy.controller;

import com.sgxy.pojo.Emp;
import com.sgxy.pojo.Loginlog;
import com.sgxy.pojo.Message;
import com.sgxy.service.EmpService;
import com.sgxy.service.LoginlogService;
import com.sgxy.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;
    @Autowired
    LoginlogService loginlogService;

    /**
     * 1.用户登录并记录用户ip地址和address
     *
     * @param no       登录账号
     * @param pass     登录密码
     * @param ip       页面获取的ip地址
     * @param city     页面获取的城市
     * @param response
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/emp_login")
    @ResponseBody//将返回值自动转化为JSON
    public ResultMessage login(String no, String pass, String ip, String city, HttpServletResponse response, HttpSession session) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        ResultMessage message = null;
        Emp emp = new Emp();
        emp.setNo(no);
        emp.setPass(pass);
        System.out.println("要登录的对象是:" + emp);
        Emp loginEmp = empService.login(emp);
        if (loginEmp != null) {
            if (loginEmp.getFlag() == 1) {
                //存session
                session.setAttribute("loginEmp", loginEmp);
                //存储用户登录的日志信息
                Loginlog loginlog = new Loginlog(ip, emp.getNo(), city);
                boolean flag = loginlogService.addLoginLog(loginlog);
                System.out.println(flag ? "日志新增成功" : "日志新增失败");
                message = new ResultMessage(200, "登录成功");
            } else {
                message = new ResultMessage(300, "账号已经被禁用，请联系管理员!");
            }
        } else {
            message = new ResultMessage(500, "账号或密码错误!");
        }
        //把message对象使用工具，转为JSON字符串，不用人工拼接
        return message;
    }

    /**
     * 2. 发送异步请求 main.jsp加载完毕之后发送异步请求 响应回json数据 把数据拼接table上
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/findLog")
    public List<Loginlog> findLog(HttpSession session) {
        //把用户信息从session域中拿出来 取出no属性值
        Emp emp = (Emp) session.getAttribute("loginEmp");
        List<Loginlog> list = loginlogService.queryLatestLog(emp.getNo());
        return list;
    }

    /**
     * 3.添加新用户信息
     *
     * @param emp
     * @return
     */
    @ResponseBody
    @RequestMapping("/empadd")
    public Message empAdd(Emp emp) {
        System.out.println(emp);
        Message m = null;
        boolean flag = empService.addEmp(emp);
        if (flag) {
            m = new Message(2, "添加成功");
        } else {
            m = new Message(3, "添加失败");
        }
        return m;
    }
    // insert into t_emp values (null,#{no},123456,#{name},#{did},1,#{sex},#{email},#{qq},#{phone},#{createdate},#{photo},0)
    //no=&name=&did=-1&sex=%E7%94%B7&email=111&phone=11&qq=111&createdate=2022-03-10&photo=059d5cadee3940fab6243bf47dcd7297%E6%BB%91%E9%93%B21+-+%E5%89%AF%E6%9C%AC.jpg
}
