package com.project.ecomapplication;

import com.project.ecomapplication.entities.Address;
import com.project.ecomapplication.entities.Roles;
import com.project.ecomapplication.entities.User;
import com.project.ecomapplication.repository.RoleRepository;
import com.project.ecomapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Override
    public void run(String... args) throws Exception {

       // List<Roles> roles = new ArrayList<>();



        Roles role1 = new Roles();
        role1.setAuthority("ROLE_ADMIN");

        Roles role2 = new Roles();
        role2.setAuthority("ROLE_CUSTOMER");

        Roles role3 = new Roles();
        role3.setAuthority("ROLE_SELLER");

        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);


        System.out.println("Total users saved::" + userRepository.count());

//        if (userRepository.count() < 1) {
        User user = new User();
        user.setFirstName("Harsh");
        user.setMiddleName("Kumar");
        user.setLastName("Gupta");
        user.setEmail("harshgupta6201@gmail.com");
//            user.setMobile(9718122312L);
        user.setPassword(passwordEncoder.encode("Admin@123"));
//        user.setInvalidAttemptCount(3);
//
        user.setIsActive(true);
        user.setIsLocked(false);
        user.setIsDeleted(false);
//
//        List<Address> addresses = new ArrayList<>();
//        Address address = new Address();
//        address.setCity("Lucknow");
//        address.setCountry("India");
//        address.setLabel("HomeTown");
//        address.setState("UP");
//        address.setZipcode("261505");
//        addresses.add(address);
//
//        address.setUser(user);
//
//        user.setAddresses(addresses);
//
//        user.setRoles(Arrays.asList(roleRepository.findByAuthority("ROLE_ADMIN").get()));
//
//        userRepository.save(user);

//        Roles role = roleRepository.findByAuthority("ROLE_ADMIN").get();
//        logger.info(role.getId()+"--------------------"+role.getAuthority());

//        Roles roles = roleRepository.findByAuthority("ROLE_ADMIN").get();
        user.setRoles(Arrays.asList(roleRepository.findByAuthority("ROLE_ADMIN").get()));
        userRepository.save(user);


    }
}