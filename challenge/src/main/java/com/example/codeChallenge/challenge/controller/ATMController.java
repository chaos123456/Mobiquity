package com.example.codeChallenge.challenge.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.codeChallenge.challenge.model.ATMDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ATMController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/getATMList",method=RequestMethod.GET)
	public ATMDetails[] getListATM() throws JsonMappingException, JsonProcessingException {
		ATMDetails[] responseMap=getDetails();
	

		return responseMap;
	}
	
	@RequestMapping(value="/getATMListByCity/{city}",method=RequestMethod.GET)
	public ATMDetails getListATMByCity(@PathVariable String city) throws JsonMappingException, JsonProcessingException {
		ATMDetails[]  responseMap = getDetails();
		for(ATMDetails filterCity:responseMap) {
			if(filterCity.getAddress().getCity().equals(city)) {
				return filterCity;
			}
			
		}
	     
		return 	null;	
	}
		
	public ATMDetails[] getDetails() throws JsonMappingException, JsonProcessingException {
		String endPoinnt="https://www.ing.nl/api/locator/atms/";
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      String response = restTemplate.exchange(endPoinnt, HttpMethod.GET, entity, String.class).getBody();
	  	String filteredresponse=response.substring(5);
		ATMDetails[] responseMap = new ObjectMapper().readValue(filteredresponse, ATMDetails[].class);
		return responseMap;
		}

}
