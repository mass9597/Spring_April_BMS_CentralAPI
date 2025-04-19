package com.bms.central_api_v1.util;

import com.bms.central_api_v1.model.AppUser;
import com.bms.central_api_v1.requestdto.CreateUserDb;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public AppUser mapCreateUserDbToAppUser(CreateUserDb createUserDb){

        AppUser user = new AppUser();

        user.setName(createUserDb.getName());
        user.setAddress(createUserDb.getAddress());
        user.setUserType(createUserDb.getUserType().toString());
        user.setEmail(createUserDb.getEmail());
        user.setPassword(createUserDb.getPassword());
        user.setPhoneNumber(createUserDb.getPhoneNumber());
        user.setPinCode(createUserDb.getPinCode());
        user.setState(createUserDb.getState());

        return user;

    }
}
