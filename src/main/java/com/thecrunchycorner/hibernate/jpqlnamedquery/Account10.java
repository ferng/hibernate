package com.thecrunchycorner.hibernate.jpqlnamedquery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
        name = Account10.QUERY_SELECT_BY_ID,
        query = "SELECT a FROM Account10 a WHERE a.id = :" + Account10.PARAM_ID
)
public class Account10 {

    public static final String QUERY_SELECT_BY_ID = "Account10.selectById";
    public static final String PARAM_ID = "id";

    @Id
    private long id;

    private long crn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCrn() {
        return crn;
    }

    public void setCrn(long crn) {
        this.crn = crn;
    }
}
