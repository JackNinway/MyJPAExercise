package com.example.myjpaexercise;

import com.example.myjpaexercise.Model.AppUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class AppUserDAOImpl implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ==============    from CLR   =================");
        AppUser appUser = new AppUser("JN","Jack", "Ninway",
                LocalDate.parse("2020-02-02"),true, "nin");

        entityManager.persist(appUser);
        entityManager.find(AppUser.class,1);
        System.out.println(appUser);

    }
}
