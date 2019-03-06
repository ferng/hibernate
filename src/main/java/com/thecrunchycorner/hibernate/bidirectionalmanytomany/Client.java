package com.thecrunchycorner.hibernate.bidirectionalmanytomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client_3")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int crnId;

    @ManyToMany(mappedBy = "clients")
    private List<Address> addresses = new ArrayList<>();

    private String title;
    private String fName;
    private String tel;

    public int getCrnId() {
        return crnId;
    }

    public void setCrnId(int crnId) {
        this.crnId = crnId;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.getClients().add(this);
    }

}
