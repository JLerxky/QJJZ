package com.jler.qjjz.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "users")
public class UsersEntity {
    private int id;
    private String uId;
    private String uName;
    private String uPwd;
    private byte[] faceImg;
    private Integer signInDay;

    public UsersEntity() {

    }

    public UsersEntity(String uid, String upwd) {
        this.uId = uid;
        this.uPwd = upwd;
    }

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
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_pwd")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Basic
    @Column(name = "face_img")
    public byte[] getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(byte[] faceImg) {
        this.faceImg = faceImg;
    }

    @Basic
    @Column(name = "sign_in_day")
    public Integer getSignInDay() {
        return signInDay;
    }

    public void setSignInDay(Integer signInDay) {
        this.signInDay = signInDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (uPwd != null ? !uPwd.equals(that.uPwd) : that.uPwd != null) return false;
        if (!Arrays.equals(faceImg, that.faceImg)) return false;
        return signInDay != null ? signInDay.equals(that.signInDay) : that.signInDay == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (uPwd != null ? uPwd.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(faceImg);
        result = 31 * result + (signInDay != null ? signInDay.hashCode() : 0);
        return result;
    }
}
