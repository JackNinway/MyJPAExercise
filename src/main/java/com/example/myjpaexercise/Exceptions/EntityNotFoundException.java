package com.example.myjpaexercise.Exceptions;

    public class EntityNotFoundException extends RuntimeException {


        public  EntityNotFoundException(String message) {
            super(message);
        }
}
