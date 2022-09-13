package com.example.myjpaexercise;

import com.example.myjpaexercise.DAO.AppUserDAO;
import com.example.myjpaexercise.Entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Profile("!test")
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    public MyCommandLineRunner(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;

    }
    private final AppUserDAO appUserDAO;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ==============    from CLR   =================");
        AppUser appUser = new AppUser("JN","Jack", "Ninway",
                LocalDate.parse("2020-02-02"),true, "nin");
        appUserDAO.save(appUser);
        Optional<AppUser> foundById= appUserDAO.findById(1);
        System.out.println("=============---  from CLR: found   ---=============\n" +foundById);
        appUserDAO.delete(appUser);
        System.out.println("=============---  from CLR: delete   ---=============\n" +appUser);
    }
}
