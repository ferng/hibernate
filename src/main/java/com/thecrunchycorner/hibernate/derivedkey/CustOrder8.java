package com.thecrunchycorner.hibernate.derivedkey;

import java.time.LocalDate;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "cust_order_8")
public class CustOrder8 {

    @EmbeddedId
    private CustOrderId orderId;

    @ManyToOne
    @JoinColumn(name = "fk_account")
    @MapsId("acId")
    private Account account;

    private LocalDate orderDate;
    private String desc;
    private int cost;

    public CustOrderId getOrderId() {
        return orderId;
    }

    public void setOrderId(CustOrderId orderId) {
        this.orderId = orderId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
