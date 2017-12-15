package com.jler.qjjz.entity;

import javax.persistence.*;

@Entity
@Table(name = "account", schema = "dbo", catalog = "QJJZ")
public class AccountEntity {
    private int id;
    private Integer uId;
    private Integer creditCard;
    private String accountName;
    private Float balance;
    private String color;
    private String note;
    private Float creditLine;
    private String statementDate;
    private String repaymentDate;

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
    @Column(name = "credit_card")
    public Integer getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Integer creditCard) {
        this.creditCard = creditCard;
    }

    @Basic
    @Column(name = "account_name")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Basic
    @Column(name = "balance")
    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
    @Column(name = "credit_line")
    public Float getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(Float creditLine) {
        this.creditLine = creditLine;
    }

    @Basic
    @Column(name = "statement_date ")
    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    @Basic
    @Column(name = "repayment_date ")
    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (id != that.id) return false;
        if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;
        if (creditCard != null ? !creditCard.equals(that.creditCard) : that.creditCard != null) return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (creditLine != null ? !creditLine.equals(that.creditLine) : that.creditLine != null) return false;
        if (statementDate != null ? !statementDate.equals(that.statementDate) : that.statementDate != null)
            return false;
        return repaymentDate != null ? repaymentDate.equals(that.repaymentDate) : that.repaymentDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (creditCard != null ? creditCard.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (creditLine != null ? creditLine.hashCode() : 0);
        result = 31 * result + (statementDate != null ? statementDate.hashCode() : 0);
        result = 31 * result + (repaymentDate != null ? repaymentDate.hashCode() : 0);
        return result;
    }
}
