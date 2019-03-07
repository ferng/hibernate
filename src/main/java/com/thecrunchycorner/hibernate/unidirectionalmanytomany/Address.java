package com.thecrunchycorner.hibernate.unidirectionalmanytomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address_5")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long adId;
    private String ad1;
    private String postCode;

    @ManyToMany
    @JoinTable(
            name = "address_client",
            joinColumns = {@JoinColumn(name = "fk_address")},
            inverseJoinColumns = {@JoinColumn(name = "fk_client")}
    )
    private List<Client> clients = new ArrayList<>();

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public List<Client> getClients() {
        return clients;
    }

    public String getAd1() {
        return ad1;
    }

    public void setAd1(String ad1) {
        this.ad1 = ad1;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

}
