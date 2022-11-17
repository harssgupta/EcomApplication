package com.project.ecomapplication.services;

import com.project.ecomapplication.entities.register.Seller;
import com.project.ecomapplication.entities.register.Token;
import com.project.ecomapplication.repository.SellerRepository;
import com.project.ecomapplication.repository.TokenRepository;
import com.project.ecomapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private TokenRepository tokenRepository;
   /* public UserEntity activate(Long id) {
        UserEntity foundUser = userRepository.findByemail(e).orElse(null);

        if(foundUser !=null && !foundUser.isActive()){

            foundUser.setActive(true);
            return userRepository.save(foundUser);

        }else {
            throw  new UsernameNotFoundException("Not found");
        }

    }


    */

   public void saveUUIDTokenWithEmail(String email, String token) {
    Token userAccessToken =  new Token();
       userAccessToken.setToken(token);
       userAccessToken.setEmail(email);
       tokenRepository.save(userAccessToken);
   }
    public ResponseEntity validateToken(String activationToken){
        Token foundToken = tokenRepository.findBytoken(activationToken);
        System.out.println(foundToken);
        if(foundToken != null){
            Seller seller = sellerRepository.findByemail(foundToken.getEmail());
            seller.setActive(true);
            sellerRepository.save(seller);
            tokenRepository.delete(foundToken);
            return new ResponseEntity<String>("Account Verified", null, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Invalid token!", null, HttpStatus.UNAUTHORIZED);
    }
  /*  @GetMapping("logout")
    public String logout(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            String tokenValue = authHeader.replace("Bearer", "").trim();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
            tokenStore.removeAccessToken(accessToken);
        }
        return "Logged out successfully";
    }

*/
}
