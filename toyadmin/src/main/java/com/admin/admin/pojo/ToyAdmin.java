package com.admin.admin.pojo;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
import java.util.Date;
public class ToyAdmin implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer aId;

    private String aUsername;

    private String aPassword;

    private String aName;

    private Integer aLevel;

    private Date aLasttime;

    private String aMark;

    private String aOne;

    private String aTwo;

    private String aThree;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaUsername() {
        return aUsername;
    }

    public void setaUsername(String aUsername) {
        this.aUsername = aUsername == null ? null : aUsername.trim();
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword == null ? null : aPassword.trim();
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public Integer getaLevel() {
        return aLevel;
    }

    public void setaLevel(Integer aLevel) {
        this.aLevel = aLevel;
    }

    public Date getaLasttime() {
        return aLasttime;
    }

    public void setaLasttime(Date aLasttime) {
        this.aLasttime = aLasttime;
    }

    public String getaMark() {
        return aMark;
    }

    public void setaMark(String aMark) {
        this.aMark = aMark == null ? null : aMark.trim();
    }

    public String getaOne() {
        return aOne;
    }

    public void setaOne(String aOne) {
        this.aOne = aOne == null ? null : aOne.trim();
    }

    public String getaTwo() {
        return aTwo;
    }

    public void setaTwo(String aTwo) {
        this.aTwo = aTwo == null ? null : aTwo.trim();
    }

    public String getaThree() {
        return aThree;
    }

    public void setaThree(String aThree) {
        this.aThree = aThree == null ? null : aThree.trim();
    }
}