package com.example.UserDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

/**
 * PersonDAO
 */
public interface PersonDAO extends JpaRepository<Person, UUID> {

    
}
