package com.example.backend;

import com.example.backend.model.Event;
import com.example.backend.service.EventServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin(origins = "https://localhost:4200")
public class EventRestController {

    @Autowired
    private EventServiceJPA eventServiceJPA;
    @Autowired
    public void setEventServiceJPA(EventServiceJPA sv){
        this.eventServiceJPA = sv;
    }

    @GetMapping({"events", "Events"})
    @ResponseBody
    public List<Event> getAll(){
        return eventServiceJPA.getAll();
    }

    @GetMapping({"event/{EventId}","Event/{EventId}"})
    @ResponseBody
    public ResponseEntity<Event> getEvent(@PathVariable("EventId") int id){
        Event e = eventServiceJPA.getEventById(id);
        return e!=null ?
                new ResponseEntity<>(e, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping({"event/{Title}","Event/{Title}"})
    @ResponseBody
    public List<Event> getEvent(@PathVariable("Title")String title){
        return eventServiceJPA.getEventsByTitle(title);
    }

    @GetMapping({"event/{EventId}/image"})
    public ResponseEntity<byte[]> getImageByEventId(@PathVariable("EventId") int id){
        Event e = eventServiceJPA.getEventById(id);
        return e!=null ?
                new ResponseEntity<>(e.getImageData(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping({"submitEvent"})
    public ResponseEntity<?> addEvent(@RequestPart Event e, @RequestPart MultipartFile imageFile){
        //System.out.println(e);
        try{
            int i = eventServiceJPA.addEvent(e, imageFile);
            return new ResponseEntity<>(i, HttpStatus.CREATED);
        }catch(IOException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@PostMapping({"submitEvent"})
    public ResponseEntity<Integer> addEvent(@ModelAttribute Event e){
        //System.out.println(e);
        int i = service.addEvent(e);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }*/

    //can make updateEvent the same as addEvent. (addOrUpdateEvent) would just call the same function in Post and Put methods
    @PutMapping({"update/{EventId}"})
    public ResponseEntity<String> updateEvent(@RequestPart Event e, @RequestPart MultipartFile imageFile){
        try{
            Event ev = eventServiceJPA.updateEvent(e, imageFile);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }catch(IOException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping({"delete/{EventId}"})
    public ResponseEntity<String> deleteEvent(@PathVariable("EventId") int id){
        Event ev = eventServiceJPA.getEventById(id);
        if(ev!=null) {
            eventServiceJPA.deleteEvent(id);
            return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
