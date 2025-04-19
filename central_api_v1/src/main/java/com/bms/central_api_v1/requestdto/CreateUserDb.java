package com.bms.central_api_v1.requestdto;

import com.bms.central_api_v1.enums.UserType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CreateUserDb {

    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private String address;
    private int pinCode;
    private String state;
    private UserType userType;
}
