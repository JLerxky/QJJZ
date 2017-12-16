package com.jler.qjjz.entity;

import javax.persistence.*;

@Entity
@Table(name = "cycle")
public class CycleEntity {
    private int id;
    private String cycleName;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cycle_name")
    public String getCycleName() {
        return cycleName;
    }

    public void setCycleName(String cycleName) {
        this.cycleName = cycleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleEntity that = (CycleEntity) o;

        if (id != that.id) return false;
        return cycleName != null ? cycleName.equals(that.cycleName) : that.cycleName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cycleName != null ? cycleName.hashCode() : 0);
        return result;
    }
}
