package com.example.backend;

import com.example.backend.model.Event;
import com.example.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
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
}
