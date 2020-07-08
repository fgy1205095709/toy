package com.admin.admin.pojo;

import com.github.pagehelper.Page;

import java.util.Collection;
import java.util.List;

/**
 * layui表格分页约定数据格式
 * @param <T>
 */
public class LayuiPageInfo<T> {

    private int code=0;//状态码,默认为0
    private long count;//总的记录数
    private List<T> data;//表格数据
    private String msg;

    public LayuiPageInfo() {
    }

    public LayuiPageInfo(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.data = list;
            this.count = page.getTotal();
        }else if (list instanceof Collection) {
            this.data = list;
            this.count = list.size();
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
