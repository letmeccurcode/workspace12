package com.sgxy.test;

import com.sgxy.mapper.EmpMapper;
import com.sgxy.pojo.Emp;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: workspace12
 * @Package com.sgxy.test
 * @Author: 鱼头哥哥
 * @WeChat:15919651285
 * @CreateTime: 2022/3/6 20:37
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmpServiceImplTest {

    @Autowired
    EmpMapper empMapper;

    @Test
    public void testLogin() {

        Emp emp = new Emp();
        emp.setNo("admin");
        emp.setPass("123");

        Emp login = empMapper.login(emp);
        System.out.println(login);

    }
}