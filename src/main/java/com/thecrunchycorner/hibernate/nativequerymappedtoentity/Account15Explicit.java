package com.thecrunchycorner.hibernate.nativequerymappedtoentity;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(
        name = "AcMapping",
        entities = @EntityResult(
                entityClass = Account15Explicit.class,
                fields = {
                        @FieldResult(name = "id", column = "acId"),
                        @FieldResult(name = "crn", column = "crn")
                }
        )
)
public class Account15Explicit {

    @Id
    private long acId;

    private long crn;

    public long getAcId() {
        return acId;
    }

    public void setAcId(long acId) {
        this.acId = acId;
    }

    public long getCrn() {
        return crn;
    }

    public void setCrn(long crn) {
        this.crn = crn;
    }
}
