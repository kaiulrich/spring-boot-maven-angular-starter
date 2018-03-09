package com.shekhargulati.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shekhargulati.app.api.UserData;
import com.shekhargulati.app.api.VerwaltenReiseprofilClient;

import lbv.wsdl.VerwaltenReiseprofilResponse;

@Service
public class UserDataService {
	
	@Autowired
	private VerwaltenReiseprofilClient verwaltenReiseprofilClient;
	
	public UserData getLocalUserData(String personalnumber) throws Exception {
		if(personalnumber.equals("1234567"))
    		return new UserData("1234567", "Max Mustermann", "max@mustermann.de", "0401234567", "Mustermann Strasse", "71001", "Stuttgart");
    	else if(personalnumber.equals("7654321"))
    		return new UserData("7654321", "Tina Tanner", "tina@tanner.de", "0407654321", "Tanner Strasse", "71007", "Stuttgart");
    	else if(personalnumber.equals("error"))
    		throw new Exception("error");
    	else
    		return null;	}
	
	public UserData getRemoteUserData(String personalnumber) throws Exception {
		VerwaltenReiseprofilResponse resp = verwaltenReiseprofilClient.getReiseprofil(personalnumber);
		if(resp == null) 
			return null;
		else if(resp.getUPRAEUSER() == null || "".equals(resp.getUPRAEUSER()))
			return null;
		
			
		return new UserData(resp.getUPRPERS().toString(), resp.getUPRAEUSER(), resp.getUPREMAILDIENST(), resp.getUPRTELEFONDIENST(), resp.getUPRDRSTRASSE(), resp.getUPRDRPLZ(), resp.getUPRDRORT());

	}

}
