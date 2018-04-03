package com.consist.lbv.app.api;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import lbv.wsdl.VerwaltenReiseprofil;
import lbv.wsdl.VerwaltenReiseprofilResponse;

public class VerwaltenReiseprofilClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(VerwaltenReiseprofilClient.class);
	
    @Value("${backend.webservice.url}")
    private String backendWebserviceUrl;

    @Value("${url}")
    private String url;


	public VerwaltenReiseprofilResponse getReiseprofil(String dienststelle, String personalnummer) {
		log.info("VerwaltenReiseprofilClient.getReiseprofil: personalnummer=" + personalnummer);
		log.info("VerwaltenReiseprofilClient.getReiseprofil: dienststelle=" + dienststelle);

		BigDecimal p = null;
		try {
			p = new BigDecimal(personalnummer);
		}catch(Exception e) {
			log.info("VerwaltenReiseprofilClient.getReiseprofil personalnummer: Error parsing BigDecimal=" + e.getMessage());
			return null;
		}
		
		BigDecimal d = null;
		try {
			d = new BigDecimal(dienststelle);
		}catch(Exception e) {
			log.info("VerwaltenReiseprofilClient.getReiseprofil dienststelle: Error parsing BigDecimal=" + e.getMessage());
			return null;
		}
		VerwaltenReiseprofil request = new VerwaltenReiseprofil();
		request.setUAKTION("HOLE");
		request.setUPRPERS(p);
		request.setUPRDSTREISE(d);

		String u = null;
		if(url != null  && !"".equals(url)) {
			log.info("VerwaltenReiseprofilClient.getReiseprofil: Webservice Backend URL: " + url);
			u = url;
		}else {
			log.info("VerwaltenReiseprofilClient.getReiseprofil: Webservice Backend URL: " + backendWebserviceUrl);
			u = backendWebserviceUrl;
		}

		/**VerwaltenReiseprofilResponse response = (VerwaltenReiseprofilResponse) getWebServiceTemplate()
				.marshalSendAndReceive(u, request,
						new SoapActionCallback("http://namespace.softwareag.com/entirex/xml/mapping/SYSTEMPort/verwaltenReiseprofilResponse"));
		**/
		return (VerwaltenReiseprofilResponse) getWebServiceTemplate()
				.marshalSendAndReceive(u, request);
	}

}