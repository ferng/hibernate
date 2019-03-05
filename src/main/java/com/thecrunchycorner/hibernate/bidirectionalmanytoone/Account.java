package com.thecrunchycorner.hibernate.bidirectionalmanytoone;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long acId;

    @OneToMany(mappedBy = "account")
    private List<CustOrder> custOrders = new ArrayList<>();

    private long crn;

    public long getAcId() {
        return acId;
    }

    public void setAcId(long acId) {
        this.acId = acId;
    }

    public List<CustOrder> getCustOrders() {
        return custOrders;
    }

    public void setCustOrders(List<CustOrder> custOrders) {
        this.custOrders = custOrders;
    }

    public long getCrn() {
        return crn;
    }

    public void setCrn(long crn) {
        this.crn = crn;
    }
}
