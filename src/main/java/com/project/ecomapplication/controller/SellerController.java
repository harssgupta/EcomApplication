package com.project.ecomapplication.controller;

import com.project.ecomapplication.dto.request.AddAddressDto;
import com.project.ecomapplication.dto.request.ChangePasswordDto;
import com.project.ecomapplication.dto.request.UpdateSellerDto;
import com.project.ecomapplication.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping("/seller-profile")
    public ResponseEntity<?> viewSellerProfile(Authentication authentication) {
        return sellerService.viewSellerProfile(authentication.getName());
    }

    @PutMapping("/update-seller-profile")
    public ResponseEntity<?> updateSellerProfile(@Valid @RequestBody UpdateSellerDto updateSellerDto, Authentication authentication) {
        return sellerService.updateSellerProfile(updateSellerDto, authentication.getName());
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changeSellerPassword(@Valid @RequestBody ChangePasswordDto changePasswordDto, Authentication authentication) {
        return sellerService.changeSellerPassword(changePasswordDto, authentication.getName());
    }

    @PutMapping("/update-seller-address")
    public ResponseEntity<?> updateSellerAddress(@RequestParam("addressId") Long id, @RequestBody AddAddressDto addAddressDto, Authentication authentication) {
        return sellerService.updateSellerAddress(id, addAddressDto, authentication.getName());
    }
}