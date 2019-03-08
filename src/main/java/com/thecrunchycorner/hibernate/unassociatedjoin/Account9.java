package com.thecrunchycorner.hibernate.unassociatedjoin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_9")
public class Account9 {

    @Id
    private long acId;

    private long crn;

    public long getAcId() {
        return acId;
    }

    public void setAcId(long acId) {
        this.acId = acId;
    }

    public long getCrn() {
        return crn;
    }

    public void setCrn(long crn) {
        this.crn = crn;
    }
}
