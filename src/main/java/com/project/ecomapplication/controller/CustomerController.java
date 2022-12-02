package com.project.ecomapplication.controller;

import com.project.ecomapplication.dto.request.AddAddressDto;
import com.project.ecomapplication.dto.request.ChangePasswordDto;
import com.project.ecomapplication.dto.request.UpdateCustomerDto;
import com.project.ecomapplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/my-profile")
    public ResponseEntity<?> viewMyProfile(Authentication authentication) {
        return customerService.viewMyProfile(authentication.getName());
    }

    @PostMapping("/add-address")
    public ResponseEntity<?> addNewAddress(Authentication authentication,
            @Valid @RequestBody AddAddressDto addAddressDto) {
        return customerService.addNewAddress(addAddressDto,
                authentication.getName());
    }

    @PutMapping("/update-address")
    public ResponseEntity<?> updateAddress(Authentication authentication, @RequestParam("addressId") Long id, @RequestBody AddAddressDto addAddressDto) {
        return customerService.updateAddress(id, addAddressDto);
    }

    @DeleteMapping("/delete-address")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<?> deleteAddress(Authentication authentication, @RequestParam("addressId") Long id) {
        return customerService.deleteAddress(id);
    }

    @GetMapping("/my-addresses")
    public ResponseEntity<?> viewMyAddresses(Authentication authentication) {
        return customerService.viewMyAddresses(authentication.getName());
    }



    @PutMapping("/change-password")
    public ResponseEntity<?> changeMyPassword(@Valid @RequestBody ChangePasswordDto changePasswordDto,
                                              Authentication authentication) {
        return customerService.changePassword(changePasswordDto,authentication.getName());
    }




    @PutMapping("/update-profile")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UpdateCustomerDto updateCustomerDto, Authentication authentication) {
        return customerService.updateMyProfile(updateCustomerDto, authentication.getName());
    }

}