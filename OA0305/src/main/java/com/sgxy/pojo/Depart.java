package com.sgxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depart {

    private Integer id;
    private String name;
    private String createtime;
    private Integer del;

}
