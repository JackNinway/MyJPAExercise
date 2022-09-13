package com.example.myjpaexercise.DAO;

import com.example.myjpaexercise.Entity.AppUser;

import java.util.Optional;

public interface AppUserDAO {
    Optional<AppUser> findById(int id);
    AppUser save(AppUser appUser);
    void delete(AppUser appUser);
}
