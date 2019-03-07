package com.thecrunchycorner.hibernate.unidirectionalmanytoone;

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
public class UniDirectionalManyToOneTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        CustOrder o1 = new CustOrder();
        CustOrder o2 = new CustOrder();
        Account ac = new Account();

        o1.setAccount(ac);
        o1.setOrderDate(LocalDate.now());
        o1.setDesc("first");
        o1.setCost(34);

        o2.setAccount(ac);
        o2.setOrderDate(LocalDate.now());
        o2.setCost(99);

        List<CustOrder> custOrders = new ArrayList<>();
        custOrders.add(o1);
        custOrders.add(o2);

        ac.setCrn(99L);

        em.persist(o1);
        em.persist(o2);
        em.persist(ac);

        CustOrder actualOrder = em.createQuery(
                "SELECT o FROM CustOrder o WHERE cost = 34",
                CustOrder.class
        ).getSingleResult();

        Assert.assertEquals(99, actualOrder.getAccount().getCrn());

    }


}
