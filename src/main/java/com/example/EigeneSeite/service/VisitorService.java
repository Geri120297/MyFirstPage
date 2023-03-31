package com.example.EigeneSeite.service;

import com.example.EigeneSeite.model.Visitor;
import com.example.EigeneSeite.repository.VisitorRepository;
import org.springframework.stereotype.Service;

import java.nio.file.FileVisitOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitorService {

    VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository){
        this.visitorRepository = visitorRepository;
    }

    public Visitor getByEmail(String email){
        Visitor visitor = visitorRepository.findByEmail(email);
        LocalDateTime now = LocalDateTime.now();
        if(visitor != null) {
            int visits = visitor.getVisit() + 1;
            visitor.setVisit(visits);
            visitor.setTimestamp(now);
            visitorRepository.save(visitor);
            return visitor;
        }else return null;
    }

    public boolean getAccess(String email){
        Visitor visitor = visitorRepository.findByEmail(email);
        if(visitor == null){
            return false;
        }
        LocalDateTime plusFiveMinutes = visitor.getTimestamp().plusMinutes(5);
        LocalDateTime now = LocalDateTime.now();
        if(plusFiveMinutes.isBefore(now)){
            return false;
        }else {
            return true;
        }
    }

    public List<Visitor> getAll(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return visitorRepository.findAllByTimestampGreaterThanAndAccessIsTrueOrTimestampIsNullAndAccessIsTrue(localDateTime);
    }
}
