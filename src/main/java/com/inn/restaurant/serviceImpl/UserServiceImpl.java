package com.inn.restaurant.serviceImpl;

import com.inn.restaurant.DAO.UserDao;
import com.inn.restaurant.POJO.User;
import com.inn.restaurant.constents.RestaurantConstent;
import com.inn.restaurant.service.UserService;
import com.inn.restaurant.utils.RestaurantUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j  //lombock annotation
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);
        //make sure after done code putt all code into try- catch block
        try {

            if (validateSignUpMap(requestMap)) {
                User user = userDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    //here we can not pass as object to find data so we need getuserfromMap()
                    userDao.save(getUserFromMap(requestMap));
                    return RestaurantUtils.getResponseEntity("Successfully registereed.", HttpStatus.OK);
                } else {
                    return RestaurantUtils.getResponseEntity("Email already exist..!!", HttpStatus.BAD_REQUEST);
                }
            } else {
                return RestaurantUtils.getResponseEntity(RestaurantConstent.INVALID_DATA, HttpStatus.BAD_REQUEST); //bad_request : 400
            }
            //return null;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return RestaurantUtils.getResponseEntity(RestaurantConstent.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateSignUpMap(Map<String,String> requestMap)
    {
       if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey(("password")))
        {
            return true;
        }
        return false;
    }
    //for user data get by map
    //if i will remove @Data annotation from User.java class then following all entity gives me error
    //because its fetch data user from Map and set all entitywise.

    private User getUserFromMap(Map<String,String> requestMap)
    {
        User user =new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
}