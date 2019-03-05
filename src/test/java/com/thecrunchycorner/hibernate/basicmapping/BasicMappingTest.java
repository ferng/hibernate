package com.thecrunchycorner.hibernate.basicmapping;

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
public class BasicMappingTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Address expected = new Address();
        expected.setAd1("22 address");
        expected.setPostCode("N1 1PP");

        em.persist(expected);

        Address actual = em.createQuery(
                "SELECT a FROM Address a WHERE id = 1"
                , Address.class
        ).getSingleResult();

        Assert.assertEquals(actual.getAdId(), actual.getAdId());
    }


}
