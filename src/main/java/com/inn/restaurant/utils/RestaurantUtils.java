package com.inn.restaurant.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestaurantUtils {
    //in this class we declare method that can be return unique id


    public RestaurantUtils() {
    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus)
    {
        return new ResponseEntity<String>("{message\":\""+responseMessage+"\"}",httpStatus);
    }
}
