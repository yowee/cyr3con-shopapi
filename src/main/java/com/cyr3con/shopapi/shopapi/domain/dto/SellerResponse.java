package com.cyr3con.shopapi.shopapi.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SellerResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
   // private Address address;
    private boolean isApproved;
}
