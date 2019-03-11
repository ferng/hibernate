package com.thecrunchycorner.hibernate.nativequerymappedtopojo;

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
public class NativeQueryMappedToPojo {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Commit
    public void process() {
        Account16 ac1 = new Account16();
        Account16 ac2 = new Account16();

        ac1.setId(3L);
        ac1.setCrn("hey");
        ac2.setId(4L);
        ac2.setCrn("how");

        em.persist(ac1);
        em.persist(ac2);

        Query query = em.createNativeQuery(
                "SELECT a.crn as here FROM Account16 a WHERE a.id = 3",
                "AcPojoMapping"
        );


        Account16Pojo actualAc = (Account16Pojo) query.getSingleResult();

        Assert.assertEquals("hey", actualAc.getHere());

    }


}
