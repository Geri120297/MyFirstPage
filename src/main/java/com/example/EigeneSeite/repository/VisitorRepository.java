package com.example.EigeneSeite.repository;

import com.example.EigeneSeite.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Visitor findByEmail(String email);
    List<Visitor> findAllByTimestampGreaterThanAndAccessIsTrueOrTimestampIsNullAndAccessIsTrue(LocalDateTime timeStamp);
}
