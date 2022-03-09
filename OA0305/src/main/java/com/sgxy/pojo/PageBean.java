package com.sgxy.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {

    private Integer pageNo;//当前页码
    private Integer pageSize;//每页展示的条数
    private Integer totalCount;//总记录数
    private Integer totalPages;//总页数 需要计算

    private Integer startno;//起始页
    private Integer endno;//结束页

    public PageBean(Integer pageNo, Integer pageSize, Integer totalCount, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.records = list;

        int x = totalCount % pageSize;
        int y = totalCount / pageSize;
        //如果x=0 商值就是总页数 否则在商值基础上+1
        this.totalPages = (x == 0 ? y : y + 1);

        if (this.totalPages <= 10) {
            this.startno = 1;
            this.endno = this.totalPages;
        } else {
            this.startno = this.pageNo - 4;
            this.endno = this.pageNo + 5;
            if (startno < 1) {
                this.startno = 1;
                this.endno = 10;
            } else if (endno > totalPages) {
                this.endno = totalPages;
                this.startno = totalPages - 9;
            }
        }
    }

    private List<T> records;
}
