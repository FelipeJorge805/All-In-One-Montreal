package com.example.backend.service;

import com.example.backend.model.Event;
import com.example.backend.repo.EventRepo;
import com.example.backend.repo.EventRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public int addEvent(Event e, MultipartFile image) throws IOException {
        e.setImageName(image.getOriginalFilename());
        e.setImageType(image.getContentType());
        e.setImageData(image.getBytes());
        return repo.save(e).getId();
    }

    public void deleteEvent(int id){
        repo.deleteById(id);
    }

    public List<Event> getAll(){
        return repo.findAll();
    }

    public Event getEventById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Event> getEventsByTitle(String title) {
        return repo.findByTitleContaining(title);
    }

    public Event updateEvent(Event e, MultipartFile image) throws IOException {
        e.setImageName(image.getOriginalFilename());
        e.setImageType(image.getContentType());
        e.setImageData(image.getBytes());
        return repo.save(e);
    }
}
