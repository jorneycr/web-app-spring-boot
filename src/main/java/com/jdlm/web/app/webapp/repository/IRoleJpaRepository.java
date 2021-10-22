package com.jdlm.web.app.webapp.repository;

import com.jdlm.web.app.webapp.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleJpaRepository extends JpaRepository<Role, Long> {
    
}
