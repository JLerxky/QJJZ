package com.jler.qjjz.entity;

import javax.persistence.*;

@Entity
@Table(name = "relationship", schema = "dbo", catalog = "QJJZ")
public class RelationshipEntity {
    private Integer uId;
    private int id;

    @Basic
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RelationshipEntity that = (RelationshipEntity) o;

        if (id != that.id) return false;
        return uId != null ? uId.equals(that.uId) : that.uId == null;
    }

    @Override
    public int hashCode() {
        int result = uId != null ? uId.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
