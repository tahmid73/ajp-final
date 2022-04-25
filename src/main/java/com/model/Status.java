package com.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int statusId=1;

    //@NotNull(message = "Id can not be empty")
    @Column(name="id")
    private int id=1;

    //@NotNull(message = "Status can not be empty")
    @Column(name="status")
    private String status;

    //@NotNull(message = "Email can not be empty")
    @Column(name = "email")
    private String email="tahmid@gmail.com";

    //@NotNull(message = "likes can not be empty")
    @Column(name = "likes")
    private int likes=0;

    public Status() {
    }

    public Status(int statusId,  String email , int id,int likes, String status) {
        this.statusId = statusId;
        this.id=id;
        this.email = email;
        this.likes=likes;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLikes(){
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
