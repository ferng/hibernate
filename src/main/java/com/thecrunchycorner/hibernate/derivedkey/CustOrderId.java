package com.thecrunchycorner.hibernate.derivedkey;

import java.io.Serializable;
import java.util.Objects;

public class CustOrderId implements Serializable {

    private static final long serialVersionUID = -5073745645379676235L;

    private String stuff;

    private long acId;


    public CustOrderId() {
    }

    public CustOrderId(String stuff, long acId) {
        this.stuff = stuff;
        this.acId = acId;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public long getAcId() {
        return acId;
    }

    public void setAcId(long acId) {
        this.acId = acId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustOrderId that = (CustOrderId) o;
        return acId == that.acId &&
                Objects.equals(stuff, that.stuff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuff, acId);
    }
}
