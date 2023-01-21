package ru.netology.exception;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String s) {
        super(s);
    }
}