package com.example.backend.repo;

import com.example.backend.model.Event;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepo {

    @Autowired
    private JdbcTemplate jdbc;

    private List<Event> events;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Event> getEvents(){
        return events;
    }

    public void setEvents(List<Event> e){
        this.events = e;
    }

    public EventRepo(){}

    @Autowired
    public EventRepo(JdbcTemplate jdbc) {
        setJdbc(jdbc);
        events = findAll();
    }

    public void save(Event e) {

        String sql = "insert into event (sid, title, description, location, dt, url) values (?,?,?,?,?,?)";

        int i = jdbc.update(sql,e.getSid(),e.getTitle(),e.getDescription(), e.getLocation(), e.getDate(), e.getUrl());
        System.out.println(i);
    }

    public List<Event> findAll() {

        String sql = "select * from event";

        return jdbc.query(sql, (rs,row) ->
                new Event(
                    rs.getInt("sid"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("location"),
                    rs.getDate("dt"),
                    rs.getString("url")
            )
        );
    }

    public Event getById(int id) {
        /*for (Event e : events){
            System.out.println(e);
            if(e.getSid() == id) return e;
        }*/
        return events.stream().filter(e -> e.getSid()==id).findFirst().orElse(null);
    }

    public Event getByTitle(String title) {
        for (Event e : events){
            if(e.getTitle().equalsIgnoreCase(title)) return e;
        }
        return null;
    }
}
