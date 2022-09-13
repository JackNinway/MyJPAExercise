package com.example.myjpaexercise.DAO;

import com.example.myjpaexercise.Exceptions.EntityNotFoundException;
import com.example.myjpaexercise.Entity.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Repository
public class AppUserDAOImpl implements AppUserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public AppUser save(AppUser appUser) {
        if(appUser == null)
            throw new IllegalArgumentException("appUser is null");
        entityManager.persist(appUser);
        return appUser;
    }
    @Transactional
    @Override
    public Optional<AppUser> findById(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("Invalid ID");
        AppUser appUser = entityManager.find(AppUser.class, id); // For Finding by ID ONLY
        return Optional.ofNullable(appUser);
//        return entityManager.find(AppUser.class, id);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class)
    @Override
    public void delete(AppUser appUser) {
        AppUser aU = findById(appUser.getId()).orElseThrow(() -> new EntityNotFoundException("data not found"));
        entityManager.remove(aU);

//        AppUser found = findById(appUser.getId());
//        if(found.getId() == appUser.getId())
//            entityManager.remove(found);
    }

}
