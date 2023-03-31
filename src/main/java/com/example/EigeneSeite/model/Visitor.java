package com.example.EigeneSeite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Visitor {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private boolean access;

    @Column
    private Integer visit;

    @Column
    private LocalDateTime timestamp;

    public Visitor(Long id, String email, boolean access, Integer visit, LocalDateTime timestamp) {
        this.id = id;
        this.email = email;
        this.access = access;
        this.visit = visit;
        this.timestamp = timestamp;
    }

    public Visitor() {

    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }
}
