package com.springboot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springboot.model.FlowerRequest;

public interface FlowerService {

	public List<Integer> getAllUserIds(String request) throws IOException ;

	public List<FlowerRequest> modifyRequest(String request) throws JsonParseException, JsonMappingException, IOException;
	
	
}
