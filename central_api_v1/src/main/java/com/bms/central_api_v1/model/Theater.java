package com.bms.central_api_v1.model;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Theater {

    private UUID id;
    private String name;
    private String address;
    private String state;
    private int pinCode;
    private AppUser owner;
    private String status;
}
