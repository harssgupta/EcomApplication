package com.project.ecomapplication.controller;

import com.project.ecomapplication.entities.AccessToken;
import com.project.ecomapplication.entities.RefreshToken;
import com.project.ecomapplication.entities.TokenDelete;
import com.project.ecomapplication.repository.AccessTokenRepository;
import com.project.ecomapplication.repository.RefreshTokenRepository;
import com.project.ecomapplication.repository.TokenDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class LogoutController {
    @Autowired
    TokenDeleteRepository tokenDeleteRepository;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @PostMapping("logout")
    @Transactional
    public String logout(@RequestParam("token") String refreshToken, HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            String tokenValue = bearerToken.substring(7, bearerToken.length());
            System.out.println(tokenValue);
            TokenDelete tokenDelete = new TokenDelete();
            Optional<RefreshToken> token=refreshTokenRepository.findByToken(refreshToken);
            tokenDelete.setToken(token.get().getToken());
            tokenDelete.setUser(token.get().getUser());
            tokenDeleteRepository.save(tokenDelete);
            refreshTokenRepository.deleteByToken(tokenValue);
        }
        return "Logged out successfully";
    }
}
