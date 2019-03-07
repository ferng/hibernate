package com.thecrunchycorner.hibernate.unidirectionalmanytomany;

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
public class UnDirectionalManyToManyTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Address ad1 = new Address();
        ad1.setAd1("11 address");
        ad1.setPostCode("N1 1PP");

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

        ad1.addClient(cl1);
        ad1.addClient(cl2);
        ad1.addClient(cl3);

        em.persist(cl1);
        em.persist(cl2);
        em.persist(cl3);
        em.persist(ad1);

        Address actAddress1 = em.createQuery(
                "SELECT a FROM Address a WHERE postCode = 'N1 1PP'",
                Address.class
        ).getSingleResult();
        Assert.assertEquals(2, actAddress1.getClients().size());
    }


}
