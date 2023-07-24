package com.speckyfox.performanceevent.repository;

import com.speckyfox.performanceevent.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {

}