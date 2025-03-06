package com.example.backend;

import com.example.backend.model.Event;
import com.example.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping({"submitEvent"})
    public ResponseEntity<Integer> addEvent(@RequestBody Event e){
        System.out.println(e);
        int i = service.addEvent(e);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

    /*@PostMapping({"submitEvent"})
    public ResponseEntity<Integer> addEvent(@ModelAttribute Event e){
        //System.out.println(e);
        int i = service.addEvent(e);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }*/

}
