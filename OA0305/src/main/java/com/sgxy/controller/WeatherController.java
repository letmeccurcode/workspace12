package com.sgxy.controller;

import com.wxapi.WxApiCall.WxApiCall;
import com.wxapi.model.RequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WeatherController {

//    1 下载京东万象查询天气的jar包
//    2 如果是maven工程需要把这些jar包安装到本地仓库
//    3 把京东万象的demo复制到工程中

    //    application/json;charset=utf-8设置第三方接口响应的json数据的编码格式
    @ResponseBody
    @RequestMapping(value = "/query_weather", produces = "application/json;charset=utf-8")
    public String queryWeather(String city) {
        RequestModel model = new RequestModel();
        model.setGwUrl("https://way.jd.com/jisuapi/weather");
        model.setAppkey("2142850432f4bd7a073771d42d525b85");
        Map queryMap = new HashMap();
        queryMap.put("city", city); //访问参数
        model.setQueryParams(queryMap);
        WxApiCall call = new WxApiCall();
        call.setModel(model);
        String s = call.request();
//        System.out.println(s);
        return s;
    }
}
