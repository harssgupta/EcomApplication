package com.project.ecomapplication.security;

import com.project.ecomapplication.entities.register.Roles;
import com.project.ecomapplication.entities.register.UserEntity;
import com.project.ecomapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       UserEntity user = userRepository.findByemail(email).orElseThrow(() -> new UsernameNotFoundException("username not found"));
       return new User(user.getEmail(),user.getPassword(),mapRoles(user.getRoles()));

    }
    private Collection<GrantedAuthority> mapRoles(Collection<Roles> roles)
    {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }

}
