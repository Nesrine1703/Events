package com.example.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event,Long> {
    @Query("select e from Event e where e.name like:name")public Page<Event> eventByNom(@Param("name") String n, Pageable pageable);}

