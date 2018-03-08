package com.shekhargulati.app.api;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import lbv.wsdl.VerwaltenReiseprofil;
import lbv.wsdl.VerwaltenReiseprofilResponse;

public class VerwaltenReiseprofilClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(VerwaltenReiseprofil.class);

	public VerwaltenReiseprofilResponse getReiseprofil(String personalnummer) {
		
		BigDecimal p = new BigDecimal(personalnummer);

		VerwaltenReiseprofil request = new VerwaltenReiseprofil();
		request.setUAKTION("HOLE");
		request.setUPRPERS(p);

		log.info("VerwaltenReiseprofilResponse quote for " + personalnummer);

		VerwaltenReiseprofilResponse response = (VerwaltenReiseprofilResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.webservicex.com/stockquote.asmx", request);

		return response;
	}

}