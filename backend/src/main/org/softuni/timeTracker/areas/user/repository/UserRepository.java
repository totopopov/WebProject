package org.softuni.timeTracker.areas.user.repository;

import org.softuni.timeTracker.areas.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);

    List<User> findAllByUsernameIsNotAndUsernameIsNot(String username, String username2);
}