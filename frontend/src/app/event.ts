export default class Event {
sid: number;
title: String;
description: String;
location: String;
date: Date;
image: String;
url: String;

    constructor(sid: number, title: String, description: String, location: String, date: Date, image: String, url: String) {
        this.sid = sid;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.image = image;
        this.url = url;
    }
}
