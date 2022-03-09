package com.sgxy.service;


import com.sgxy.pojo.Loginlog;

import java.util.List;

public interface LoginlogService {

    boolean addLoginLog(Loginlog log);

    List<Loginlog> queryLatestLog(String no);
}
