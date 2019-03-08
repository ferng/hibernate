package com.thecrunchycorner.hibernate.jpqlcallstandardfunction;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class StandardFunction {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Account12 ac1 = new Account12();
        Account12 ac2 = new Account12();

        ac1.setId(3L);
        ac1.setCrn(33L);
        ac2.setId(4L);
        ac2.setCrn(42L);

        em.persist(ac1);
        em.persist(ac2);

        Query query = em.createQuery(
                "SELECT a, sqrt(a.crn) FROM Account12 a GROUP BY a.id"
        );

        List<Object[]> results = query.getResultList();

        Assert.assertEquals(33, results.size());

    }


}
