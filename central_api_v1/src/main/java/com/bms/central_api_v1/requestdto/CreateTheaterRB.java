package com.bms.central_api_v1.requestdto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateTheaterRB {

    private String name;
    private String address;
    private String state;
    private int pinCode;

}
