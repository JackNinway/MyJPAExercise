package com.example.myjpaexercise.DAO;

import com.example.myjpaexercise.Entity.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // it configures the test DB
@AutoConfigureTestEntityManager
@DirtiesContext // This tells Spring to clear the Application context after the test has run.
@Transactional

class AppUserDAOImplTest {
    @Autowired
    AppUserDAO appUserDAO;
    @Autowired
    TestEntityManager entityManager;
    @Transactional
    @Test
    void save() {
        AppUser appUser = new AppUser("JN","Jack", "Ninway",
                LocalDate.parse("2020-02-02"),true, "nin");
        appUserDAO.save(appUser);
        assertNotEquals(0, appUser.getId());
    }

    @Test
    void findById() {
        AppUser appUser = new AppUser("JN","Jack", "Ninway",
                LocalDate.parse("2020-02-02"),true, "nin");
        Integer id = entityManager.persistAndGetId(appUser, Integer.class);
        entityManager.clear();

        Optional<AppUser> foundAppUser = appUserDAO.findById(id);

        assertTrue(foundAppUser.isPresent());
        assertEquals(id, foundAppUser.get().getId());
    }

    @Test
    void delete() {
        AppUser appUser = new AppUser("JN","Jack", "Ninway",
                LocalDate.parse("2020-02-02"),true, "nin");
        appUserDAO.save(appUser);
        appUserDAO.delete(appUser);
        System.out.println("=============---  from CLR: delete   ---=============\n" +appUser);

    }
}