package com.bms.central_api_v1.service;


import com.bms.central_api_v1.exception.UnAuthorizedException;
import com.bms.central_api_v1.integration.DbApi;
import com.bms.central_api_v1.model.AppUser;
import com.bms.central_api_v1.model.Theater;
import com.bms.central_api_v1.requestdto.CreateTheaterRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TheaterService {

    @Autowired
    UserService userService;

    @Autowired
    DbApi dbApi;

    public Theater raiseTheaterCreationRequest(CreateTheaterRB createTheaterRB, UUID theaterOwnerId){
         boolean isTheaterOwner = userService.isTheaterOwner(theaterOwnerId);

         if(!isTheaterOwner){
             throw new UnAuthorizedException(String.format(
                     "UserID %s does not have access to add theater to the application",theaterOwnerId.toString()
             ));

         }

         AppUser owner = userService.getUserById(theaterOwnerId);

         return dbApi.createTheater(createTheaterRB,owner);


    }
}
