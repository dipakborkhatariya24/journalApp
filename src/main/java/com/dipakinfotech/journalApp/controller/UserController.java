package com.dipakinfotech.journalApp.controller;

import com.dipakinfotech.journalApp.Repository.UserRepository;
import com.dipakinfotech.journalApp.apiResponce.WeatherResponce;
import com.dipakinfotech.journalApp.entity.User;
import com.dipakinfotech.journalApp.service.UserService;
import com.dipakinfotech.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponce weatherResponce = weatherService.getWeather("Mumbai");
        String greeting = "";
        if (weatherResponce != null) {
            greeting = "weather feels like " + weatherResponce.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("hii " + authentication.getName() + greeting, HttpStatus.OK);
    }


}
