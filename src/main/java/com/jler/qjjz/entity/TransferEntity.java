package com.jler.qjjz.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transfer")
public class TransferEntity {
    private int id;
    private Float amount;
    private Date date;
    private Integer inAccount;
    private String note;
    private Integer outAccount;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "in_account")
    public Integer getInAccount() {
        return inAccount;
    }

    public void setInAccount(Integer inAccount) {
        this.inAccount = inAccount;
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
    @Column(name = "out_account")
    public Integer getOutAccount() {
        return outAccount;
    }

    public void setOutAccount(Integer outAccount) {
        this.outAccount = outAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferEntity that = (TransferEntity) o;

        if (id != that.id) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (inAccount != null ? !inAccount.equals(that.inAccount) : that.inAccount != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (outAccount != null ? !outAccount.equals(that.outAccount) : that.outAccount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (inAccount != null ? inAccount.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (outAccount != null ? outAccount.hashCode() : 0);
        return result;
    }
}
