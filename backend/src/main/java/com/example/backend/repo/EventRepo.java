package com.example.backend.repo;

import com.example.backend.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepo {

    private JdbcTemplate jdbc;
    private List<Event> events;

    public EventRepo() {
        events = findAll();
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Event e) {

        String sql = "insert into event (sid, title, description, location, dt, url) values (?,?,?,?,?,?)";

        int i = jdbc.update(sql,e.getSid(),e.getTitle(),e.getDescription(), e.getLocation(), e.getDate(), e.getUrl());
        System.out.println(i);
    }

    public List<Event> findAll() {

        String sql = "select * from events";

        return jdbc.query(sql, (rs,row) ->
                new Event(
                    rs.getInt("sid"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("location"),
                    rs.getDate("dt"),
                    rs.getString("url")
            )
        );
    }
}
