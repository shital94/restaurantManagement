package com.inn.restaurant.restImpl;

import com.inn.restaurant.constents.RestaurantConstent;
import com.inn.restaurant.rest.UserRest;
import com.inn.restaurant.service.UserService;
import com.inn.restaurant.utils.RestaurantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        //return null;
        try
        {
            return userService.signUp(requestMap);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //return new ResponseEntity<String>("{\"message\":\"Something Went Wrong..!\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        return RestaurantUtils.getResponseEntity(RestaurantConstent.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
