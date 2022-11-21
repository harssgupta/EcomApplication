package com.project.ecomapplication.services;

import com.project.ecomapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenService {
    @Autowired
    UserRepository userRepository;

}