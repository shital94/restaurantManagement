package com.inn.restaurant.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/user")  //in one class have multiple API possible
public interface UserRest {

    //key pair value mapping
    @PostMapping(path = "/signup")
    public ResponseEntity<String> signup(@RequestBody(required = true) Map<String,String> requestMap);

    ResponseEntity<String> signUp(Map<String, String> requestMap);
}
