package DAO;

import Model.AppUser;

public interface AppUserDAO {
    AppUser findById(int id);
    AppUser save(AppUser appUser);
    AppUser delete(AppUser appUser);
}
