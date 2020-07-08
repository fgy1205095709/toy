package com.admin.admin.pojo;

public class ToyLog {
    private Integer lId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    private String lContent;

    private String lMark;

    private String lOne;

    private String lTwo;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public String getlContent() {
        return lContent;
    }

    public void setlContent(String lContent) {
        this.lContent = lContent == null ? null : lContent.trim();
    }

    public String getlMark() {
        return lMark;
    }

    public void setlMark(String lMark) {
        this.lMark = lMark == null ? null : lMark.trim();
    }

    public String getlOne() {
        return lOne;
    }

    public void setlOne(String lOne) {
        this.lOne = lOne == null ? null : lOne.trim();
    }

    public String getlTwo() {
        return lTwo;
    }

    public void setlTwo(String lTwo) {
        this.lTwo = lTwo == null ? null : lTwo.trim();
    }
}