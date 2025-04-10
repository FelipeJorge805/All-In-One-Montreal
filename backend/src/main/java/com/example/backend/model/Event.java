package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Component
@Scope("prototype")
@Entity
public class Event implements Serializable {

    @Id
    private final int id;

    private static int sid = 0;

    //@GeneratedValue(strategy = GenerationType.UUID)
    //private UUID id;

    private String title;
    private String description;
    private String location;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;
    private String url;

    public Event(int id, String title, String description, String location, LocalDate date, String url) {
        sid++;
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = (date);
        this.url = url;
        System.out.println("parameter Event constructor");
    }

    public Event(Event e) {
        this.id = sid++;
        this.title = e.title;
        this.description = e.description;
        this.location = e.location;
        this.date = e.date;
        //this.image = e.image;
        this.url = e.url;
        System.out.println("copy Event constructor");
    }
    public Event(){
        this.id = sid++;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                //", image='" + image + '\'' +
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getImage() {
        return "";//image;
    }

    public void setImage(String image) {
        //this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
