package com.springboot.service;

import java.io.IOException;
import java.util.List;

import javax.management.InstanceNotFoundException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springboot.model.FlowerRequest;
import com.springboot.model.FlowerResponse;

public interface FlowerService {

	public List<FlowerResponse> getAllUserIds(String request) throws IOException ;

	public List<FlowerRequest> modifyRequest(String request) throws JsonParseException, JsonMappingException, IOException;

	public List<FlowerRequest> modifyRequestById(String request, int id) throws JsonParseException, JsonMappingException, IOException, InstanceNotFoundException, Exception;
	
	
}
