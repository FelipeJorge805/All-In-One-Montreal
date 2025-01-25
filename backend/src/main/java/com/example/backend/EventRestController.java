package com.example.backend;

import com.example.backend.model.Event;
import com.example.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "https://localhost:4200")
public class EventRestController {

    @Autowired
    private EventService service;
    @Autowired
    public void setService(EventService sv){
        this.service = sv;
    }

    @GetMapping({"events", "Events"})
    @ResponseBody
    public List<Event> getAll(){
        return service.getAll();
    }

    @GetMapping({"event/{EventId}","Event/{EventId}"})
    @ResponseBody
    public Event getEvent(@PathVariable("EventId") int id){
        return service.getEventById(id);
    }

    @GetMapping({"event/{Title}","Event/{Title}"})
    @ResponseBody
    public Event getEvent(@PathVariable("Title")String title){
        return service.getEventByTitle(title);
    }
}
