package com.thecrunchycorner.hibernate.jpqlselectpojo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
public class SelectPojo {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Account11 ac1 = new Account11();
        Account11 ac2 = new Account11();

        ac1.setId(3L);
        ac1.setCrn(33L);
        ac2.setId(4L);
        ac2.setCrn(42L);

        em.persist(ac1);
        em.persist(ac2);

        TypedQuery<Account11back> query = em.createQuery(
                "SELECT " +
                        "new com.thecrunchycorner.hibernate.jpqlselectpojo.Account11back (" +
                        "a.id, a.crn) FROM Account11 a " +
                        "WHERE a.id = :id",
                Account11back.class
        );


        query.setParameter("id", 3L);

        Account11back actualAc = query.getSingleResult();

        Assert.assertEquals(33, actualAc.getCrn());

    }


}
