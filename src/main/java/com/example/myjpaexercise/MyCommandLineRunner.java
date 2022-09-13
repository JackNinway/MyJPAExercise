package com.example.myjpaexercise;

import com.example.myjpaexercise.DAO.AppUserDAO;
import com.example.myjpaexercise.DAO.AppUserDAOImpl;
import com.example.myjpaexercise.Model.AppUser;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;

public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AppUserDAO appUserDAO = new AppUserDAOImpl();
        System.out.println(" ==============    from CLR   =================");
        AppUser appUser = new AppUser("JN","Jack", "Ninway",
                LocalDate.parse("2020-02-02"),true, "nin");
        appUserDAO.save(appUser);
        appUser = appUserDAO.findById(1);
        System.out.println("=============---  from CLR: found   ---=============\n" +appUser);
        appUserDAO.delete(appUser);
    }
}
