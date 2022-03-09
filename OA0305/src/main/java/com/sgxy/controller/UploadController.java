package com.sgxy.controller;

import com.sgxy.pojo.Emp;
import com.sgxy.pojo.Message;
import com.sgxy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {

    @Autowired
    EmpService es;

    @ResponseBody
    @RequestMapping("/photoupload")
    public Message photoupload(MultipartFile file, HttpSession session) throws IOException {
        //文件上传的请求方法中需要定义一个参数 名称默认是file
        //文件上传解析器CommonsMultipartResolver会自动解析request中的文件上传项并且赋值给请求方法中的MultipartFile file
        //获取上传的文件名称
        String filename = file.getOriginalFilename();
        // 防止文件名相同被覆盖
        filename = UUID.randomUUID().toString().replace("-", "") + filename;
        //指定上传文件的真实路径
        String realPath = session.getServletContext().getRealPath("/media/upload");
        //指定文件上传的路径
        File f = new File(realPath);
        //如果文件夹不存在就创建
        if (!f.exists()) {
            f.mkdirs();
        }
        file.transferTo(new File(f, filename));
        return new Message(2, filename);
    }

    @RequestMapping("/photoupdate")
    public String photoupdate(MultipartFile file, HttpSession session) throws IOException {
        //获取上传的文件名称
        System.out.println(file == null);
        String filename = file.getOriginalFilename();
        // 防止文件名相同被覆盖
        filename = UUID.randomUUID().toString().replace("-", "") + filename;
        System.out.println(filename);
        //指定上传文件的真实路径
        String realPath = session.getServletContext().getRealPath("/media/uploads");
        System.out.println(realPath);
        //指定文件上传的路径
        File f = new File(realPath);
        //如果文件夹不存在就创建
        if (!f.exists()) {
            f.mkdirs();
        }

        file.transferTo(new File(f, filename));

        Emp e = (Emp) session.getAttribute("emp");

        //        根据id更新用户的photo
//        es.updatePhoto(e.getId(), filename);

        e.setPhoto(filename);
        session.setAttribute("emp", e);

        return "main";
    }
}
