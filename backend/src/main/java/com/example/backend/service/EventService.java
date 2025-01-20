package com.example.backend.service;

import com.example.backend.model.Event;
import com.example.backend.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    public EventRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(EventRepo repo) {
        this.repo = repo;
    }

    @Autowired
    private EventRepo repo;

    public void addEvent(Event e){
        repo.save(e);
    }

    public List<Event> getAll(){
        return repo.findAll();
    }
}
