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
}
