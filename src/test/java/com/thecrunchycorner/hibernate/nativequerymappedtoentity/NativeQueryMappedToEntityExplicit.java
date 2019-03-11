package com.thecrunchycorner.hibernate.nativequerymappedtoentity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class NativeQueryMappedToEntityExplicit {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Account15Implicit ac1 = new Account15Implicit();
        Account15Implicit ac2 = new Account15Implicit();

        ac1.setId(3L);
        ac1.setCrn(33L);
        ac2.setId(4L);
        ac2.setCrn(42L);

        em.persist(ac1);
        em.persist(ac2);

        Query query = em.createNativeQuery(
                "SELECT id as acId, crn FROM Account15Implicit a WHERE id = 3",
                "AcMapping"
        );


        Account15Explicit actualAc = (Account15Explicit) query.getSingleResult();

        Assert.assertEquals(33, actualAc.getCrn());

    }


}
