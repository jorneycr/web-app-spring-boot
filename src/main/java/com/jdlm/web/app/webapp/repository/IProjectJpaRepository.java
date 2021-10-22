package com.jdlm.web.app.webapp.repository;

import com.jdlm.web.app.webapp.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectJpaRepository extends JpaRepository<Project,Long> {
    Project findByName(String name);
}
