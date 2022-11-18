package com.project.ecomapplication.controller;

import com.project.ecomapplication.dto.AuthResponseDTO;
import com.project.ecomapplication.dto.LoginDTO;
import com.project.ecomapplication.dto.RegisterDTO;
import com.project.ecomapplication.entities.register.Roles;
import com.project.ecomapplication.entities.register.Seller;
import com.project.ecomapplication.repository.RolesRepository;
import com.project.ecomapplication.repository.SellerRepository;
import com.project.ecomapplication.repository.UserRepository;
import com.project.ecomapplication.security.JWTGenerator;

import com.project.ecomapplication.services.EmailSenderServices;
import com.project.ecomapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerRegisterLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private UserService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private JWTGenerator jwtGenerator;

    @Autowired
    private EmailSenderServices emailSenderService;



    //register
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {
        if (userRepository.existsByemail(registerDto.getEmail())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        Seller user = new Seller();
//      UserEntity user = new UserEntity();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Roles roles = rolesRepository.findByAuthority("SELLER").get();
        user.setRoles(Collections.singletonList(roles));

        sellerRepository.save(user);
        String ID= UUID.randomUUID().toString();
        String URL="http://localhost:8080/seller/activate?token="+ID;
        service.saveUUIDTokenWithEmail(registerDto.getEmail(),ID);

        emailSenderService.sendEmail(registerDto.getEmail(),"HELLO SELLER ",URL);
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    //login
    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);


        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
    @PutMapping("activate")
    ResponseEntity activateUser(@RequestParam("token") String activationToken)
    {
        return service.validateToken(activationToken);
    }



}