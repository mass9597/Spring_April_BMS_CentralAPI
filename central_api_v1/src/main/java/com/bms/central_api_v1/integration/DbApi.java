package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.model.AppUser;
import com.bms.central_api_v1.requestdto.CreateUserDb;
import com.bms.central_api_v1.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class DbApi {

    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    public AppUser CreateUser(CreateUserDb createUserDb){

        AppUser user = mapper.mapCreateUserDbToAppUser(createUserDb); // this will convert the requestdto to appuser class

        String url = baseUrl+"/user/create";
        URI finalUrl = URI.create(url);

        RequestEntity request = RequestEntity.post(finalUrl).body(user);

        //TO HIT the endpoint we need resttemplate library

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AppUser> response = restTemplate.exchange(finalUrl, HttpMethod.POST,request, AppUser.class);

        return response.getBody();
    }
}
