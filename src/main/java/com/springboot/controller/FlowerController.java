package com.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.model.FlowerRequest;

@RestController
public class FlowerController {

	@RequestMapping(value = "/getAllUserIds")
	public List<Integer> getAllUserIds(@RequestBody String request) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Integer> userIdList = new ArrayList<>();
		try {
			if(!request.isBlank()) {
				List<FlowerRequest> flowerRequestList = Arrays.asList(mapper.readValue(request, FlowerRequest[].class));
				userIdList= flowerRequestList.stream().map(FlowerRequest::getUserId).distinct()
						.collect(Collectors.toList());
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return userIdList;

	}

	@RequestMapping(value = "/modifyRequest")
	public List<FlowerRequest> modifyRequest(@RequestBody String request) throws JSONException, JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<FlowerRequest> flowerRequestList = new ArrayList<>();
		if(!request.isBlank()) {
			flowerRequestList = Arrays.asList(mapper.readValue(request, FlowerRequest[].class));
			Predicate<FlowerRequest> p1 = obj->obj.getUserId()==1;
			Predicate<FlowerRequest> p2 = obj->obj.getId()==4;
			flowerRequestList.stream().filter(p1.and(p2)).peek(o->o.setTitle("1800Flowers")).forEach(o->o.setBody("1800Flowers"));
			
		}
		return flowerRequestList;

	}
}