package com.example.backend.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
public class Event {

    static int sid = 1;
    String title;
    String description;
    String location;
    Date date;
    String image;
    String url;

    public Event(int id, String title, String description, String location, Date date, String url) {
        sid = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = (date);
        this.url = url;
        System.out.println("parameter Event constructor");
    }

    public Event() {
        sid++;
        System.out.println("empty Event constructor");
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSid() {
        return sid;
    }
}
