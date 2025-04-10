package com.example.backend;

import com.example.backend.model.Event;
import com.example.backend.service.EventService;
import com.example.backend.service.EventServiceJPA;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin(origins = "https://localhost:4200")
public class EventRestController {

    @Autowired
    private EventServiceJPA service;
    @Autowired
    public void setService(EventServiceJPA sv){
        this.service = sv;
    }

    @GetMapping({"events", "Events"})
    @ResponseBody
    public List<Event> getAll(){
        return service.getAll();
    }

    @GetMapping({"event/{EventId}","Event/{EventId}"})
    @ResponseBody
    public ResponseEntity<Event> getEvent(@PathVariable("EventId") int id){
        Event e = service.getEventById(id);
        return e!=null ?
                new ResponseEntity<>(e, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping({"event/{Title}","Event/{Title}"})
    @ResponseBody
    public List<Event> getEvent(@PathVariable("Title")String title){
        return service.getEventsByTitle(title);
    }

    @GetMapping({"event/{EventId}/image"})
    public ResponseEntity<byte[]> getImageByEventId(@PathVariable("EventId") int id){
        Event e = service.getEventById(id);
        return e!=null ?
                new ResponseEntity<>(e.getImageData(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping({"submitEvent"})
    public ResponseEntity<?> addEvent(@RequestPart Event e, @RequestPart MultipartFile imageFile){
        //System.out.println(e);
        try{
            int i = service.addEvent(e, imageFile);
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

    @PutMapping({"update/{EventId}"})
    public ResponseEntity<Event> updateEvent(@RequestBody Event e){
        return new ResponseEntity<>(service.update(e), HttpStatus.OK);
    }

    @DeleteMapping({"delete/{EventId}"})
    public ResponseEntity<Void> deleteEvent(@PathVariable("EventId") int id){
        service.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
