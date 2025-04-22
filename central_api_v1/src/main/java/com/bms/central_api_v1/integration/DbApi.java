package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.model.AppUser;
import com.bms.central_api_v1.model.Theater;
import com.bms.central_api_v1.requestdto.CreateTheaterRB;
import com.bms.central_api_v1.requestdto.CreateUserDb;
import com.bms.central_api_v1.util.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.UUID;

@Service
public class DbApi extends RestApi{

    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    @Autowired
    ModelMapper modelMapper;

    public AppUser createUser(CreateUserDb createUserDb){

        AppUser user = mapper.mapCreateUserDbToAppUser(createUserDb); // this will convert the requestdto to appuser class

        String apiEndPoint = "/user/create";

        Object response = this.makePostCall(baseUrl,apiEndPoint,user, new HashMap<>());

        AppUser res = modelMapper.map(response,AppUser.class);

        return res;
    }

    public AppUser getUserById(UUID userID){

        String endPoint = "/user/"+ userID.toString();

        Object response = this.makeGetCall(baseUrl,endPoint,new HashMap<>());

        if(response == null){
            return null;
        }

        AppUser user = modelMapper.map(response,AppUser.class);

        return user;

    }

    public Theater createTheater(CreateTheaterRB createTheaterRB, AppUser owner){

        // convert the dto to theater class

        Theater theater = mapper.mapCreateTheaterRBToTheater(createTheaterRB,owner);

        String endPoint = "/theater/create";

        Object res = this.makePostCall(baseUrl,endPoint,theater,new HashMap<>());

        return modelMapper.map(res,Theater.class);
    }
}
