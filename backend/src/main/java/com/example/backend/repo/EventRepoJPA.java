package com.example.backend.repo;

import com.example.backend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepoJPA extends JpaRepository<Event, Integer> {


}
