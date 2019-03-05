package com.thecrunchycorner.hibernate.bidirectionalmanytoone;

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
public class BidirectionalManyToOneTest {

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
        o2.setDesc("second");
        o2.setCost(99);

        List<CustOrder> custOrders = new ArrayList<>();
        custOrders.add(o1);
        custOrders.add(o2);

        ac.setCustOrders(custOrders);
        ac.setCrn(99L);

        em.persist(o1);
        em.persist(o2);
        em.persist(ac);

        Account actualAc = em.createQuery(
                "SELECT a FROM Account a WHERE crn = 99",
                Account.class
        ).getSingleResult();

        Assert.assertEquals(2, actualAc.getCustOrders().size());


    }


}
