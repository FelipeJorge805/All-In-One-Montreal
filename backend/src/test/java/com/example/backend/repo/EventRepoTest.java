package com.example.backend.repo;

import com.example.backend.model.Event;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.convention.TestBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EventRepoTest {

    @TestBean
    @Autowired
    private EventRepo repo= new EventRepo();

    @BeforeEach
    public void setUp(){
        List<Event> es = List.of(new Event[]{
                new Event(1, "title1", "desc1", "loc1", null, "url1"),
                new Event(2, "title2", "desc2", "loc2", null, "url2"),
                new Event(3,"title3", "desc3", "loc3", null, "url3")
        });

        repo.setEvents(es);

        assertNotNull(repo.getEvents());
    }

    @Test
    public void findByIdTest(){
        Event e = repo.getById(2);

        assertTrue(e != null && e.getSid() == 2);
    }
}