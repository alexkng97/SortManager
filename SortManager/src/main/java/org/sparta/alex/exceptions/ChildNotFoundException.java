package org.sparta.alex.exceptions;

public class ChildNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Child does not exist";
    }
}
