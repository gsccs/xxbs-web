package com.gsccs.cmcc.info.model;

public class UsercorpT {
    private String id;

    private Long userid;

    private String ispcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getIspcode() {
        return ispcode;
    }

    public void setIspcode(String ispcode) {
        this.ispcode = ispcode == null ? null : ispcode.trim();
    }
}