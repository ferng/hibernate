package com.thecrunchycorner.hibernate.derivedkey;

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
public class DerivedKey {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        CustOrder8 o1 = new CustOrder8();
        Account ac = new Account();

        o1.setOrderId(new CustOrderId());
        o1.getOrderId().setStuff("yes");
        o1.setAccount(ac);
        o1.setOrderDate(LocalDate.now());
        o1.setDesc("first");
        o1.setCost(34);

        List<CustOrder8> custOrder8s = new ArrayList<>();
        custOrder8s.add(o1);

        ac.setCrn(99L);


        em.persist(ac);
        em.persist(o1);

        CustOrder8 actualOrder = em.createQuery(
                "SELECT o FROM CustOrder8 o WHERE cost = 34",
                CustOrder8.class
        ).getSingleResult();

        Assert.assertEquals(99, actualOrder.getAccount().getCrn());

    }


}
