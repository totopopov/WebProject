package org.softuni.timeTracker.areas.time.repository;


import org.softuni.timeTracker.areas.time.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    Project findByProject(String project);

    List<Project> findAllByEnabledTrue();
}