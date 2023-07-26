package com.speckyfox.performanceevent.repository;

import com.speckyfox.performanceevent.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

    /**
     * Find event by title
     *
     * @param name String
     * @return Optional of event
     */
    Optional<Events> findEventByTitle(String name);
}
