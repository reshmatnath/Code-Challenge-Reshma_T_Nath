package com.springboot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springboot.model.FlowerRequest;
import com.springboot.model.FlowerResponse;
import com.springboot.service.FlowerService;

@RestController
public class FlowerController {
	
	@Autowired
	FlowerService flowerServices;

	@RequestMapping(value = "/getAllUserIdCount")
	public Map<String,Long> getAllUserIdCount(@RequestBody String request) throws IOException {
		
		return flowerServices.getAllUserIdCount(request);

	}

	@RequestMapping(value = "/modifyRequest")
	public List<FlowerRequest> modifyRequest(@RequestBody String request) throws JSONException, JsonParseException, JsonMappingException, IOException {
		
		return flowerServices.modifyRequest(request);

	}
	
	@RequestMapping(value = "/getAllUserIds")
	public List<FlowerResponse> getAllUserIds(@RequestBody String request) throws IOException {
		
		return flowerServices.getAllUserIds(request);

	}

	@RequestMapping(value = "/modifyRequestById/{id}")
	public List<FlowerRequest> modifyRequestById(@PathVariable int id,@RequestBody String request) throws Exception {
		
		return flowerServices.modifyRequestById(request,id);

	}
}