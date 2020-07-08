package com.admin.admin.pojo;

import java.util.Date;

public class ToyReport {
    private Integer reId;

    private Integer reUserid;

    private Integer reBuserid;

    private Integer reIdeaid;

    private Integer reUrsid;

    private String reType;

    private String reTypetwo;

    private String reContent;

    private Date reTime;

    private Integer reIf;

    private Integer reAdminid;

    private Integer reIsitvalid;

    private String reResult;

    private String reReason;

    private Date reResulttime;

    private String reOne;

    private String reTwo;

    private String reThree;
    private ToyAdmin toyAdmin;
    public ToyAdmin getToyAdmin() {
        return toyAdmin;
    }
    public void setToyAdmin(ToyAdmin toyAdmin) {
        this.toyAdmin = toyAdmin;
    }

    private ToyUser toyUser;
    public ToyUser getToyUser() {
        return toyUser;
    }
    public void setToyUser(ToyUser toyUser) {
        this.toyUser = toyUser;
    }
    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getReUserid() {
        return reUserid;
    }

    public void setReUserid(Integer reUserid) {
        this.reUserid = reUserid;
    }

    public Integer getReBuserid() {
        return reBuserid;
    }

    public void setReBuserid(Integer reBuserid) {
        this.reBuserid = reBuserid;
    }

    public Integer getReIdeaid() {
        return reIdeaid;
    }

    public void setReIdeaid(Integer reIdeaid) {
        this.reIdeaid = reIdeaid;
    }

    public Integer getReUrsid() {
        return reUrsid;
    }

    public void setReUrsid(Integer reUrsid) {
        this.reUrsid = reUrsid;
    }

    public String getReType() {
        return reType;
    }

    public void setReType(String reType) {
        this.reType = reType == null ? null : reType.trim();
    }

    public String getReTypetwo() {
        return reTypetwo;
    }

    public void setReTypetwo(String reTypetwo) {
        this.reTypetwo = reTypetwo == null ? null : reTypetwo.trim();
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent == null ? null : reContent.trim();
    }

    public Date getReTime() {
        return reTime;
    }

    public void setReTime(Date reTime) {
        this.reTime = reTime;
    }

    public Integer getReIf() {
        return reIf;
    }

    public void setReIf(Integer reIf) {
        this.reIf = reIf;
    }

    public Integer getReAdminid() {
        return reAdminid;
    }

    public void setReAdminid(Integer reAdminid) {
        this.reAdminid = reAdminid;
    }

    public Integer getReIsitvalid() {
        return reIsitvalid;
    }

    public void setReIsitvalid(Integer reIsitvalid) {
        this.reIsitvalid = reIsitvalid;
    }

    public String getReResult() {
        return reResult;
    }

    public void setReResult(String reResult) {
        this.reResult = reResult == null ? null : reResult.trim();
    }

    public String getReReason() {
        return reReason;
    }

    public void setReReason(String reReason) {
        this.reReason = reReason == null ? null : reReason.trim();
    }

    public Date getReResulttime() {
        return reResulttime;
    }

    public void setReResulttime(Date reResulttime) {
        this.reResulttime = reResulttime;
    }

    public String getReOne() {
        return reOne;
    }

    public void setReOne(String reOne) {
        this.reOne = reOne == null ? null : reOne.trim();
    }

    public String getReTwo() {
        return reTwo;
    }

    public void setReTwo(String reTwo) {
        this.reTwo = reTwo == null ? null : reTwo.trim();
    }

    public String getReThree() {
        return reThree;
    }

    public void setReThree(String reThree) {
        this.reThree = reThree == null ? null : reThree.trim();
    }
}