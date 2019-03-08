package com.thecrunchycorner.hibernate.unassociatedjoin;

import java.time.LocalDate;
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
public class unAssociatedJoin {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        CustOrder9 o1 = new CustOrder9();
        CustOrder9 o2 = new CustOrder9();
        Account9 ac1 = new Account9();
        Account9 ac2 = new Account9();

        o1.setAcId(3L);
        o1.setOrderDate(LocalDate.now());
        o1.setDesc("first");
        o1.setCost(34);

        o2.setAcId(4L);
        o2.setOrderDate(LocalDate.now());
        o2.setDesc("second");
        o2.setCost(99);

        ac1.setAcId(3L);
        ac1.setCrn(33L);
        ac2.setAcId(4L);
        ac2.setCrn(42L);

        em.persist(o1);
        em.persist(o2);
        em.persist(ac1);
        em.persist(ac2);

        Account9 actualAc = em.createQuery(
                "SELECT a " +
                        "FROM CustOrder9 o " +
                        "JOIN Account9 a ON o.acId = a.acId " +
                        "WHERE o.cost = 34",
                Account9.class
        ).getSingleResult();

        Assert.assertEquals(33, actualAc.getCrn());

    }


}
