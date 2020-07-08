package com.admin.admin.pojo;

public class ToyClassification {
    private Integer cId;

    private Integer cBigid;

    private String cName;

    private String cDescribe;

    private Integer cCount;

    private Integer cScan;

    private Integer cState;

    private String cMark;

    private String cOne;

    private String cTwo;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getcBigid() {
        return cBigid;
    }

    public void setcBigid(Integer cBigid) {
        this.cBigid = cBigid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcDescribe() {
        return cDescribe;
    }

    public void setcDescribe(String cDescribe) {
        this.cDescribe = cDescribe == null ? null : cDescribe.trim();
    }

    public Integer getcCount() {
        return cCount;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }

    public Integer getcScan() {
        return cScan;
    }

    public void setcScan(Integer cScan) {
        this.cScan = cScan;
    }

    public Integer getcState() {
        return cState;
    }

    public void setcState(Integer cState) {
        this.cState = cState;
    }

    public String getcMark() {
        return cMark;
    }

    public void setcMark(String cMark) {
        this.cMark = cMark == null ? null : cMark.trim();
    }

    public String getcOne() {
        return cOne;
    }

    public void setcOne(String cOne) {
        this.cOne = cOne == null ? null : cOne.trim();
    }

    public String getcTwo() {
        return cTwo;
    }

    public void setcTwo(String cTwo) {
        this.cTwo = cTwo == null ? null : cTwo.trim();
    }
}