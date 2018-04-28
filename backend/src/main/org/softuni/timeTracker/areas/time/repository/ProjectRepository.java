package org.softuni.timeTracker.areas.time.repository;


import org.softuni.timeTracker.areas.time.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    Project findByProject(String project);

}