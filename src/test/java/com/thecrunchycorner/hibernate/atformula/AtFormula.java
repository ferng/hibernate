package com.thecrunchycorner.hibernate.atformula;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AtFormula {

    @Autowired
    private EntityManager em;

    @Before
    @Transactional
    public void prep() {
        Address7 expected = new Address7();
        expected.setAd1("22 address");
        expected.setPostCode("N1 1PP");
        expected.setDate(LocalDateTime.now().minusMonths(64));

        em.persist(expected);
    }

    @Test
    @Transactional
    @Commit
    public void process() {


        Address7 actual = em.createQuery(
                "SELECT a FROM Address7 a WHERE id = 1"
                , Address7.class
        ).getSingleResult();

        Assert.assertEquals(actual.getAdId(), actual.getAdId());
    }


}
