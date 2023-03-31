package com.example.EigeneSeite.controller;

import com.example.EigeneSeite.model.PostsMain;
import com.example.EigeneSeite.repository.PostsMainRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postsMain")
public class PostsMainController {

    PostsMainRepository postsMainRepository;

    public PostsMainController(PostsMainRepository postsMainRepository){
        this.postsMainRepository = postsMainRepository;
    }


    @GetMapping
    public List<PostsMain> getAllPosts(){
        return postsMainRepository.findAll();
    }

    @PostMapping("/create")
    public PostsMain createPost(@RequestBody PostsMain postsMain){
        return postsMainRepository.save(postsMain);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postsMainRepository.deleteById(id);
    }
}
