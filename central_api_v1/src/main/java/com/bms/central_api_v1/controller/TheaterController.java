package com.bms.central_api_v1.controller;


import com.bms.central_api_v1.exception.UnAuthorizedException;
import com.bms.central_api_v1.exception.UserNotFoundException;
import com.bms.central_api_v1.model.Theater;
import com.bms.central_api_v1.requestdto.CreateTheaterRB;
import com.bms.central_api_v1.responseBody.GeneralMessageResponse;
import com.bms.central_api_v1.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/register")
    public ResponseEntity<?> registerTheater(@RequestBody CreateTheaterRB createTheaterRB,
                                          @RequestParam UUID ownerId){

        try{
            Theater theater = theaterService.raiseTheaterCreationRequest(createTheaterRB,ownerId);
            return new ResponseEntity<>(theater, HttpStatus.CREATED);
        }
        catch(UnAuthorizedException e){
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity<>(message,HttpStatus.UNAUTHORIZED);
        }
        catch(UserNotFoundException e){
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
