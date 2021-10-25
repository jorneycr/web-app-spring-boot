package com.jdlm.web.app.webapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jdlm.web.app.webapp.model.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoleJpaRepositoryTest {
    
    @Autowired
    private IRoleJpaRepository repoRole;

    @Test
    public void roleTest(){
        Role admin = new Role("ROLE_ADMIN");
        admin = repoRole.save(admin);
        assertNotNull(admin);
        assertNotNull(admin.getId());
        assertEquals("ROLE_ADMIN", admin.getName());
        assertEquals(admin.getId(), repoRole.findByName("ROLE_ADMIN").getId());

    }
}
