package com.example.myjpaexercise.DAO;

import com.example.myjpaexercise.Entity.ToDoItem;

import java.util.Optional;

public interface ToDoItemDAO {
    Optional<ToDoItem> findById(String id);
    ToDoItem save(ToDoItem tdI);
    ToDoItem update(ToDoItem tdI);
    ToDoItem delete(ToDoItem tdI);

}
