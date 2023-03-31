package com.example.EigeneSeite.controller;

import com.example.EigeneSeite.service.VisitorService;
import com.example.EigeneSeite.model.Visitor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

    private VisitorService visitorService;

    public VisitorController(VisitorService visitorService){
        this.visitorService = visitorService;
    }

    @GetMapping("/{email}")
    public Visitor findByVisitor(@PathVariable String email){
        return visitorService.getByEmail(email);
    }

    @GetMapping("/access/{email}")
    public boolean getAccess(@PathVariable String email){
        return visitorService.getAccess(email);
    }

    @GetMapping("/list")
    public List<Visitor> getAll(){
        return visitorService.getAll();
    }
}
