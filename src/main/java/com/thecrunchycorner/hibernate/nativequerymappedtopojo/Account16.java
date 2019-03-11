package com.thecrunchycorner.hibernate.nativequerymappedtopojo;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(
        name = "AcPojoMapping",
        classes = @ConstructorResult(
                targetClass = Account16Pojo.class,
                columns = {
                        @ColumnResult(name = "here")
                }
        )
)
public class Account16 {

    @Id
    private long id;

    private String crn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }
}
