export default class Event {
id: number;
title: String;
description: String;
location: String;
date: Date;
image: String;
url: String;

    constructor(id: number, title: String, description: String, location: String, date: Date, image: String, url: String) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.image = image;
        this.url = url;
    }

    setImage(image: String) {
        this.image = image;
    }
}
