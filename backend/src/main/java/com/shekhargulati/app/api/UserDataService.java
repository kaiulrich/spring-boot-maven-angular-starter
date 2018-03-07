package com.shekhargulati.app.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDataService {

    @GetMapping(path = "userdata/{personalnumber}")
    public UserData getUserData(@PathVariable(name="personalnumber") String personalnumber) {
    	if(personalnumber.equals("1234567"))
    		return new UserData("1234567", "Marc", "Mustermann");
    	else if(personalnumber.equals("7654321"))
    		return new UserData("7654321", "Frida", "Meier");
    	else if(personalnumber.equals("11111111"))
    		return new UserData("11111111", "do", "test");
    	else
    		return null;
    }
}
