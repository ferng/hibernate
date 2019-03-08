package com.thecrunchycorner.hibernate.jpqlselectpojo;

public class Account11back {

    private long id;

    private long crn;

    public Account11back(long id, long crn) {
        this.id = id;
        this.crn = crn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCrn() {
        return crn;
    }

    public void setCrn(long crn) {
        this.crn = crn;
    }
}
