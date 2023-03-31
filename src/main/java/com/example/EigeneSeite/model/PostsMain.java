package com.example.EigeneSeite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class PostsMain {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String text;


    public PostsMain(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public PostsMain(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titel) {
        this.title = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
