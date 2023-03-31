package com.example.EigeneSeite.repository;

import com.example.EigeneSeite.model.PostsMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsMainRepository extends JpaRepository<PostsMain, Long> {
}
