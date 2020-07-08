package com.admin.admin.pojo;

import java.util.Date;

public class ToyNeed {
    private Integer nId;

    private String nTitle;

    private String nImg;

    private Date nPubtime;

    private Integer nUserid;

    private Integer nGetclick;

    private Integer nScan;

    private Integer nState;

    private String nMark;

    private Integer nIf;

    private Integer nIdeaid;

    private Integer nIfcheck;

    private Integer nChecker;

    private Date nChecktime;

    private String nOne;

    private String nTwo;

    private String nThree;

    private String nContent;
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
    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle == null ? null : nTitle.trim();
    }

    public String getnImg() {
        return nImg;
    }

    public void setnImg(String nImg) {
        this.nImg = nImg == null ? null : nImg.trim();
    }

    public Date getnPubtime() {
        return nPubtime;
    }

    public void setnPubtime(Date nPubtime) {
        this.nPubtime = nPubtime;
    }

    public Integer getnUserid() {
        return nUserid;
    }

    public void setnUserid(Integer nUserid) {
        this.nUserid = nUserid;
    }

    public Integer getnGetclick() {
        return nGetclick;
    }

    public void setnGetclick(Integer nGetclick) {
        this.nGetclick = nGetclick;
    }

    public Integer getnScan() {
        return nScan;
    }

    public void setnScan(Integer nScan) {
        this.nScan = nScan;
    }

    public Integer getnState() {
        return nState;
    }

    public void setnState(Integer nState) {
        this.nState = nState;
    }

    public String getnMark() {
        return nMark;
    }

    public void setnMark(String nMark) {
        this.nMark = nMark == null ? null : nMark.trim();
    }

    public Integer getnIf() {
        return nIf;
    }

    public void setnIf(Integer nIf) {
        this.nIf = nIf;
    }

    public Integer getnIdeaid() {
        return nIdeaid;
    }

    public void setnIdeaid(Integer nIdeaid) {
        this.nIdeaid = nIdeaid;
    }

    public Integer getnIfcheck() {
        return nIfcheck;
    }

    public void setnIfcheck(Integer nIfcheck) {
        this.nIfcheck = nIfcheck;
    }

    public Integer getnChecker() {
        return nChecker;
    }

    public void setnChecker(Integer nChecker) {
        this.nChecker = nChecker;
    }

    public Date getnChecktime() {
        return nChecktime;
    }

    public void setnChecktime(Date nChecktime) {
        this.nChecktime = nChecktime;
    }

    public String getnOne() {
        return nOne;
    }

    public void setnOne(String nOne) {
        this.nOne = nOne == null ? null : nOne.trim();
    }

    public String getnTwo() {
        return nTwo;
    }

    public void setnTwo(String nTwo) {
        this.nTwo = nTwo == null ? null : nTwo.trim();
    }

    public String getnThree() {
        return nThree;
    }

    public void setnThree(String nThree) {
        this.nThree = nThree == null ? null : nThree.trim();
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent == null ? null : nContent.trim();
    }
}