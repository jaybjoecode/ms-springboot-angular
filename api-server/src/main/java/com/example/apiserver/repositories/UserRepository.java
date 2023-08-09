package com.example.apiserver.repositories;

import com.example.apiserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "select u from User u where u.id = ?1")
    User getUserById(long id);
}
