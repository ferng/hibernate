package com.thecrunchycorner.hibernate.jpqlpagination;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account13 {

    @Id
    private long id;

    private long crn;

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
