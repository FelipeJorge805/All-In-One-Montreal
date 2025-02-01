package com.example.backend.service;

import com.example.backend.model.Event;
import com.example.backend.repo.EventRepo;
import com.example.backend.repo.EventRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceJPA {

    @Autowired
    private EventRepoJPA repo;

    public EventRepoJPA getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(EventRepoJPA repo) {
        this.repo = repo;
    }

    public void addEvent(Event e){
        repo.save(e);
    }

    public void deleteEvent(Event e){
        repo.delete(e);
    }

    public List<Event> getAll(){
        return repo.findAll();
    }

    public Event getEventById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Event> getEventsByTitle(String title) {
        return repo.findByTitle(title);
    }
}
