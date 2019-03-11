package com.thecrunchycorner.hibernate.nativequery;

import com.thecrunchycorner.hibernate.jpqlselectpojo.Account11;
import com.thecrunchycorner.hibernate.jpqlselectpojo.Account11back;
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
public class NativeQuery {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Account14 ac1 = new Account14();
        Account14 ac2 = new Account14();

        ac1.setId(3L);
        ac1.setCrn(33L);
        ac2.setId(4L);
        ac2.setCrn(42L);

        em.persist(ac1);
        em.persist(ac2);

        Query query = em.createNativeQuery(
                "SELECT * FROM Account14 a WHERE a.id = ?",
                Account14.class
        );


        query.setParameter(1, 3L);

        Account14 actualAc = (Account14) query.getSingleResult();

        Assert.assertEquals(33, actualAc.getCrn());

    }


}
