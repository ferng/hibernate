package com.thecrunchycorner.hibernate.jpqlpagination;

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
public class Pagination {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        for(int i =0; i < 20; i++) {
            Account13 ac = new Account13();
            ac.setId(i);
            ac.setCrn(i+100);
            em.persist(ac);
        }

        List<Account13> accsA = em.createQuery(
                "SELECT a FROM Account13 a ORDER BY a.id",
                Account13.class
        ).setFirstResult(0)
                .setMaxResults(7)
                .getResultList();


        List<Account13> accsB = em.createQuery(
                "SELECT a FROM Account13 a ORDER BY a.id",
                Account13.class
        ).setFirstResult(10)
                .setMaxResults(7)
                .getResultList();



        Assert.assertEquals(106, accsA.get(6).getCrn());
        Assert.assertEquals(116, accsB.get(6).getCrn());

    }


}
