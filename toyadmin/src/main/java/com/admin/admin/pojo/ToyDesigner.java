package com.admin.admin.pojo;

import java.util.Date;

public class ToyDesigner {
    private Integer dId;

    private Integer dUId;

    private String dDescribe;

    private String dSignature;

    private Integer dWorkcount;

    private String dTruename;

    private Integer dTruecard;

    private String dAddress;

    private Integer dGrade;

    private Date dCreatetime;

    private Integer dState;

    private Integer dIfreport;

    private String dMark;

    private String dOne;

    private String dTwo;

    private String dThree;


    private ToyUser toyUser;
    public ToyUser getToyUser() {
        return toyUser;
    }
    public void setToyUser(ToyUser toyUser) {
        this.toyUser = toyUser;
    }


    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getdUId() {
        return dUId;
    }

    public void setdUId(Integer dUId) {
        this.dUId = dUId;
    }

    public String getdDescribe() {
        return dDescribe;
    }

    public void setdDescribe(String dDescribe) {
        this.dDescribe = dDescribe == null ? null : dDescribe.trim();
    }

    public String getdSignature() {
        return dSignature;
    }

    public void setdSignature(String dSignature) {
        this.dSignature = dSignature == null ? null : dSignature.trim();
    }

    public Integer getdWorkcount() {
        return dWorkcount;
    }

    public void setdWorkcount(Integer dWorkcount) {
        this.dWorkcount = dWorkcount;
    }

    public String getdTruename() {
        return dTruename;
    }

    public void setdTruename(String dTruename) {
        this.dTruename = dTruename == null ? null : dTruename.trim();
    }

    public Integer getdTruecard() {
        return dTruecard;
    }

    public void setdTruecard(Integer dTruecard) {
        this.dTruecard = dTruecard;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress == null ? null : dAddress.trim();
    }

    public Integer getdGrade() {
        return dGrade;
    }

    public void setdGrade(Integer dGrade) {
        this.dGrade = dGrade;
    }

    public Date getdCreatetime() {
        return dCreatetime;
    }

    public void setdCreatetime(Date dCreatetime) {
        this.dCreatetime = dCreatetime;
    }

    public Integer getdState() {
        return dState;
    }

    public void setdState(Integer dState) {
        this.dState = dState;
    }

    public Integer getdIfreport() {
        return dIfreport;
    }

    public void setdIfreport(Integer dIfreport) {
        this.dIfreport = dIfreport;
    }

    public String getdMark() {
        return dMark;
    }

    public void setdMark(String dMark) {
        this.dMark = dMark == null ? null : dMark.trim();
    }

    public String getdOne() {
        return dOne;
    }

    public void setdOne(String dOne) {
        this.dOne = dOne == null ? null : dOne.trim();
    }

    public String getdTwo() {
        return dTwo;
    }

    public void setdTwo(String dTwo) {
        this.dTwo = dTwo == null ? null : dTwo.trim();
    }

    public String getdThree() {
        return dThree;
    }

    public void setdThree(String dThree) {
        this.dThree = dThree == null ? null : dThree.trim();
    }
}