package com.nestdigital.twitterclonebackendapp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue

    private int id;
    private int user_id;
    private String posted_date;
    private String post;

    public PostModel() {
    }

    public PostModel(int id, int user_id, String posted_date, String post) {
        this.id = id;
        this.user_id = user_id;
        this.posted_date = posted_date;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public void setPosted_date(String posted_date) {
        this.posted_date = posted_date;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}


