package com.consist.lbv.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consist.lbv.app.api.UserData;
import com.consist.lbv.app.api.VerwaltenReiseprofilClient;

import lbv.wsdl.VerwaltenReiseprofilResponse;

@Service
public class UserDataService {
	
	private static final Logger log = LoggerFactory.getLogger(UserDataService.class);

	
	@Autowired
	private VerwaltenReiseprofilClient verwaltenReiseprofilClient;
	
	public UserData getLocalUserData(String dienststelle, String personalnumber) throws Exception {
		if(personalnumber.equals("1234567"))
    		return new UserData("1234567", "Max Mustermann", "max@mustermann.de", "0401234567", "Mustermann Strasse", "71001", "Stuttgart");
    	else if(personalnumber.equals("7654321"))
    		return new UserData("7654321", "Tina Tanner", "tina@tanner.de", "0407654321", "Tanner Strasse", "71007", "Stuttgart");
    	else if(personalnumber.equals("error"))
    		throw new Exception("error");
    	else
    		return null;	}
	
	public UserData getRemoteUserData(String dienststelle, String personalnumber) throws Exception {
		VerwaltenReiseprofilResponse resp = verwaltenReiseprofilClient.getReiseprofil(dienststelle, personalnumber );
		if(resp == null) {
			log.info("UserDataService.getRemoteUserData: Response=null");
			return null;
		}else if(resp.getUPRAEUSER() == null || "".equals(resp.getUPRAEUSER())) {
			
			log.info("UserDataService.getRemoteUserData: getUPRAEUSER() is empty");
			return null;
		}
			
		UserData ud =  new UserData(resp.getUPRPERS().toString(), resp.getUPRAEUSER(), resp.getUPREMAILDIENST(), resp.getUPRTELEFONDIENST(), resp.getUPRDRSTRASSE(), resp.getUPRDRPLZ(), resp.getUPRDRORT());
		log.info("UserDataService.getRemoteUserData: UserData: " + ud.toString());
		return ud;

	}

}
