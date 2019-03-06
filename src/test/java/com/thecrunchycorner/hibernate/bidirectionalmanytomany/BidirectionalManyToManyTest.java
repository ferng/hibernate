package com.thecrunchycorner.hibernate.bidirectionalmanytomany;

import com.thecrunchycorner.hibernate.bidirectionalmanytoone.Account;
import com.thecrunchycorner.hibernate.bidirectionalmanytoone.CustOrder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BidirectionalManyToManyTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Address ad1 = new Address();
        ad1.setAd1("11 address");
        ad1.setPostCode("N1 1PP");

        Address ad2 = new Address();
        ad2.setAd1("22 address");
        ad2.setPostCode("N2 2PP");

        Address ad3 = new Address();
        ad3.setAd1("33 address");
        ad3.setPostCode("N3 3PP");

        Client cl1 = new Client();
        cl1.setTitle("Mr");
        cl1.setfName("Fern");
        cl1.setTel("020 111111");

        Client cl2 = new Client();
        cl2.setTitle("Miss");
        cl2.setfName("Jasmin");
        cl2.setTel("020 222222");

        Client cl3 = new Client();
        cl3.setTitle("Ms");
        cl3.setfName("Clara");
        cl3.setTel("020 3333");

        cl1.addAddress(ad1);
        cl2.addAddress(ad2);
        cl2.addAddress(ad3);
        ad3.addClient(cl3);

        em.persist(cl1);
        em.persist(cl2);
        em.persist(cl3);
        em.persist(ad1);
        em.persist(ad2);
        em.persist(ad3);


        Client actClient1 = em.createQuery(
                "Select c FROM Client c WHERE fName = 'Fern'",
                Client.class
        ).getSingleResult();
        Assert.assertEquals(1, actClient1.getAddresses().size());

        Client actClient2 = em.createQuery(
                "Select c FROM Client c WHERE fName = 'Jasmin'",
                Client.class
        ).getSingleResult();
        Assert.assertEquals(2, actClient2.getAddresses().size());

        Address actAddress3 = em.createQuery(
                "SELECT a FROM Address a WHERE postCode = 'N3 3PP'",
                Address.class
        ).getSingleResult();
        Assert.assertEquals(2, actAddress3.getClients().size());
    }


}
