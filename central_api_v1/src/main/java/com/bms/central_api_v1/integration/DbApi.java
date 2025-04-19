package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.model.AppUser;
import com.bms.central_api_v1.requestdto.CreateUserDb;
import com.bms.central_api_v1.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;

import java.net.URI;

public class DbApi {

    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    public void CreateUser(CreateUserDb createUserDb){

        AppUser user = mapper.mapCreateUserDbToAppUser(createUserDb); // this will convert the requestdto to appuser class

        String url = baseUrl+"/user/create";
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.post(finalUrl).body(user);
    }
}
