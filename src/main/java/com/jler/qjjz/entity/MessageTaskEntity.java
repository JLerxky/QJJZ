package com.jler.qjjz.entity;

import javax.persistence.*;

@Entity
@Table(name = "messageTask", schema = "dbo", catalog = "QJJZ")
public class MessageTaskEntity {
    private int id;
    private Integer uId;
    private String note;
    private Integer cycleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "u_id")
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "cycle_id")
    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageTaskEntity that = (MessageTaskEntity) o;

        if (id != that.id) return false;
        if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        return cycleId != null ? cycleId.equals(that.cycleId) : that.cycleId == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (cycleId != null ? cycleId.hashCode() : 0);
        return result;
    }
}
