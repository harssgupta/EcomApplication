package com.project.ecomapplication.exceptions.email;

public interface EmailSender {
    void send(String to, String email);
}