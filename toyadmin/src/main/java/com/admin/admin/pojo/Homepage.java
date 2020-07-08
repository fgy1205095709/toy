package com.admin.admin.pojo;

/**
 * @anther fgy
 * @title
 * @time 2019-10-18 20:09
 */
public class Homepage {

    int userid;
    int userideacount;
    int userordercount;

    String uname;
    String udescribe;
    String uphone;

    public int getUserordercount() {
        return userordercount;
    }

    public void setUserordercount(int userordercount) {
        this.userordercount = userordercount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserideacount() {
        return userideacount;
    }

    public void setUserideacount(int userideacount) {
        this.userideacount = userideacount;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUdescribe() {
        return udescribe;
    }

    public void setUdescribe(String udescribe) {
        this.udescribe = udescribe;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }
}
