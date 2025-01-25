package com.example.backend;

import com.example.backend.model.Event;
import com.example.backend.service.EventService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(BackendApplication.class, args);

		Event e = context.getBean(Event.class);
		e.setTitle("Ice skating");
		e.setDescription("Have fun with family");
		e.setLocation("Place des arts");
		e.setDate(Date.valueOf("2024-12-24"));
		e.setUrl("www.google.com");

		System.out.println(e);

		EventService service = context.getBean(EventService.class);

		//service.addEvent(e);
	}

}
