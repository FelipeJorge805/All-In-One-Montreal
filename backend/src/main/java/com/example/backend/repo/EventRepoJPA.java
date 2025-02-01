package com.example.backend.repo;

import com.example.backend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepoJPA extends JpaRepository<Event, Integer> {

    List<Event> findByTitle(String title);
}
