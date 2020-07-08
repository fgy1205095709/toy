package com.admin.admin.pojo;

public class ToyOrder {
    private Integer oId;

    private Integer oUserid;

    private Integer oIdeaid;

    private Integer oBuserid;

    private String oUserphone;

    private String oBuserphone;

    private Integer oIf;

    private String oMark;

    private Integer oPrice;

    private String oOne;

    private String oTwo;

    private String oThree;

    private ToyUser toyUser;

    private ToyCreateidea toyCreateidea;

    private ToyAdmin toyAdmin;

    public ToyAdmin getToyAdmin() {
        return toyAdmin;
    }

    public void setToyAdmin(ToyAdmin toyAdmin) {
        this.toyAdmin = toyAdmin;
    }

    public ToyUser getToyUser() {
        return toyUser;
    }
    public void setToyUser(ToyUser toyUser) {
        this.toyUser = toyUser;
    }


    public ToyCreateidea getToyCreateidea() {
        return toyCreateidea;
    }

    public void setToyCreateidea(ToyCreateidea toyCreateidea) {
        this.toyCreateidea = toyCreateidea;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getoUserid() {
        return oUserid;
    }

    public void setoUserid(Integer oUserid) {
        this.oUserid = oUserid;
    }

    public Integer getoIdeaid() {
        return oIdeaid;
    }

    public void setoIdeaid(Integer oIdeaid) {
        this.oIdeaid = oIdeaid;
    }

    public Integer getoBuserid() {
        return oBuserid;
    }

    public void setoBuserid(Integer oBuserid) {
        this.oBuserid = oBuserid;
    }

    public String getoUserphone() {
        return oUserphone;
    }

    public void setoUserphone(String oUserphone) {
        this.oUserphone = oUserphone == null ? null : oUserphone.trim();
    }

    public String getoBuserphone() {
        return oBuserphone;
    }

    public void setoBuserphone(String oBuserphone) {
        this.oBuserphone = oBuserphone == null ? null : oBuserphone.trim();
    }

    public Integer getoIf() {
        return oIf;
    }

    public void setoIf(Integer oIf) {
        this.oIf = oIf;
    }

    public String getoMark() {
        return oMark;
    }

    public void setoMark(String oMark) {
        this.oMark = oMark == null ? null : oMark.trim();
    }

    public Integer getoPrice() {
        return oPrice;
    }

    public void setoPrice(Integer oPrice) {
        this.oPrice = oPrice;
    }

    public String getoOne() {
        return oOne;
    }

    public void setoOne(String oOne) {
        this.oOne = oOne == null ? null : oOne.trim();
    }

    public String getoTwo() {
        return oTwo;
    }

    public void setoTwo(String oTwo) {
        this.oTwo = oTwo == null ? null : oTwo.trim();
    }

    public String getoThree() {
        return oThree;
    }

    public void setoThree(String oThree) {
        this.oThree = oThree == null ? null : oThree.trim();
    }
}