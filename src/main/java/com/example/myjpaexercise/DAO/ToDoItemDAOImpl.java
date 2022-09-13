package com.example.myjpaexercise.DAO;

import com.example.myjpaexercise.Entity.ToDoItem;

import java.util.Optional;

public class ToDoItemDAOImpl implements ToDoItemDAO{

    @Override
    public Optional<ToDoItem> findById(String id) {
        return Optional.empty();
    }

    @Override
    public ToDoItem save(ToDoItem tdI) {
        return null;
    }

    @Override
    public ToDoItem update(ToDoItem tdI) {
        return null;
    }

    @Override
    public ToDoItem delete(ToDoItem tdI) {
        return null;
    }
}
