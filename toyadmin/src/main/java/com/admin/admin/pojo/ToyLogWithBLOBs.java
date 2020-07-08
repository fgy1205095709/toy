package com.admin.admin.pojo;

public class ToyLogWithBLOBs extends ToyLog {
    private String lOldvalue;

    private String lNewvalue;

    public String getlOldvalue() {
        return lOldvalue;
    }

    public void setlOldvalue(String lOldvalue) {
        this.lOldvalue = lOldvalue == null ? null : lOldvalue.trim();
    }

    public String getlNewvalue() {
        return lNewvalue;
    }

    public void setlNewvalue(String lNewvalue) {
        this.lNewvalue = lNewvalue == null ? null : lNewvalue.trim();
    }
}