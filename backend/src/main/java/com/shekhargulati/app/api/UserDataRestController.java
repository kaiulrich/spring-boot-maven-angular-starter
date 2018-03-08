package com.shekhargulati.app.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shekhargulati.app.UserDataService;

@RestController
public class UserDataRestController {
	
	@Autowired
	private UserDataService userDataService;

    @GetMapping(path = "userdata/{personalnumber}")
    public UserData getUserData(@PathVariable(name="personalnumber") String personalnumber) throws Exception {
    	return userDataService.getRemoteUserData(personalnumber);
    }
}
