package com.jler.qjjz.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "message", schema = "dbo", catalog = "QJJZ")
public class MessageEntity {
    private int id;
    private Integer uId;
    private String note;
    private Date time;

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
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != that.id) return false;
        if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
