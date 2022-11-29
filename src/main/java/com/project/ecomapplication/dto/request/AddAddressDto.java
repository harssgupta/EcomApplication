package com.project.ecomapplication.dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddAddressDto {

    @NotNull
    @NotBlank(message = "Access token cannot be blank")
    private String accessToken;

    @NotNull
    @NotBlank(message = "Address cannot be blank")
    private String addressLine;

    @NotNull
    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotNull
    @NotBlank(message = "State cannot be blank")
    private String state;

    @NotNull
    @NotBlank(message = "Country cannot be blank")
    private String country;

    @NotNull
    @NotBlank(message = "Zip code cannot be blank")
    @Size(min = 6, max = 6, message = "It should be exact 6 digits")
    private String zipcode;

    @NotNull
    @NotBlank(message = "Label cannot be blank")
    private String label;
}