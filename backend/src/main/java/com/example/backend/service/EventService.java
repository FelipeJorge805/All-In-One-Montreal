package com.example.backend.service;

import com.example.backend.model.Event;
import com.example.backend.repo.EventRepo;
import com.example.backend.repo.EventRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo repo;
    @Autowired
    private EventRepoJPA repoJPA;

    public EventRepoJPA getRepoJPA() {
        return repoJPA;
    }

    @Autowired
    public void setRepoJPA(EventRepoJPA repoJPA) {
        this.repoJPA = repoJPA;
    }

    public EventRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(EventRepo repo) {
        this.repo = repo;
    }

    public void addEvent(Event e){
        //repo.save(e);
        repoJPA.save(e);
    }

    public List<Event> getAll(){
        return repo.findAll();
    }

    public Event getEventById(int id) {
        return repo.getById(id);
    }

    public Event getEventByTitle(String title) {
        return repo.getByTitle(title);
    }
}
