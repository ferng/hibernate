package com.thecrunchycorner.hibernate.namedquery;

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
public class NamedQuery {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Account10 ac1 = new Account10();
        Account10 ac2 = new Account10();

        ac1.setId(3L);
        ac1.setCrn(33L);
        ac2.setId(4L);
        ac2.setCrn(42L);

        em.persist(ac1);
        em.persist(ac2);

        TypedQuery<Account10> query =
                em.createNamedQuery(Account10.QUERY_SELECT_BY_ID, Account10.class);

        query.setParameter(Account10.PARAM_ID, 3L);

        Account10 actualAc = query.getSingleResult();

        Assert.assertEquals(33, actualAc.getCrn());

    }


}
