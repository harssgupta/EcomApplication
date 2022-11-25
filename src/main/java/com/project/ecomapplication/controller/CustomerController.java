package com.project.ecomapplication.controller;

import com.project.ecomapplication.dto.request.AddAddressDto;
import com.project.ecomapplication.dto.request.ChangePasswordDto;
import com.project.ecomapplication.dto.request.UpdateCustomerDto;
import com.project.ecomapplication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/my-profile")
    public ResponseEntity<?> viewMyProfile(@RequestParam("accessToken") String accessToken) {
        return customerService.viewMyProfile(accessToken);
    }

    @PostMapping("/add-address")
    public ResponseEntity<?> addNewAddress(@Valid @RequestBody AddAddressDto addAddressDto) {
        return customerService.addNewAddress(addAddressDto);
    }

    @PutMapping("/update-address")
    public ResponseEntity<?> updateAddress(@RequestParam("addressId") Long id, @RequestBody AddAddressDto addAddressDto) {
        return customerService.updateAddress(id, addAddressDto);
    }

    @DeleteMapping("/delete-address")
    public ResponseEntity<?> deleteAddress(@RequestParam("accessToken") String accessToken, @RequestParam("addressId") Long id) {
        return customerService.deleteAddress(accessToken, id);
    }

    @GetMapping("/my-addresses")
    public ResponseEntity<?> viewMyAddresses(@RequestParam("accessToken") String accessToken) {
        return customerService.viewMyAddresses(accessToken);
    }



    @PutMapping("/change-password")
    public ResponseEntity<?> changeMyPassword(@Valid @RequestBody ChangePasswordDto changePasswordDto) {
        return customerService.changePassword(changePasswordDto);
    }




    @PutMapping("/update-profile")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UpdateCustomerDto updateCustomerDto) {
        return customerService.updateMyProfile(updateCustomerDto);
    }

    @PostMapping(value = "/upload-image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> uploadImage(@RequestParam("accessToken") String accessToken, @RequestPart("image") MultipartFile multipartFile) {
        return customerService.uploadImage(accessToken, multipartFile);
    }
}