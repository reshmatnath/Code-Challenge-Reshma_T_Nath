package com.springboot.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.model.FlowerRequest;
import com.springboot.model.FlowerResponse;
import com.springboot.service.FlowerService;

@Service
public class FlowerServiceImpl implements FlowerService {
	
	@Override
	public Map<String, Long> getAllUserIdCount(String request) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Long> userCount = new HashMap<>();
		try {
			if (!request.isBlank()) {
				List<FlowerRequest> flowerRequestList = Arrays.asList(mapper.readValue(request, FlowerRequest[].class));
				long count = flowerRequestList.stream().map(FlowerRequest::getUserId).distinct().count();
				userCount.put("Unique User Count", count);

			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return userCount;
	}

	public List<FlowerRequest> modifyRequest(String request)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<FlowerRequest> flowerRequestList = new ArrayList<>();
		if (!request.isBlank()) {
			flowerRequestList = Arrays.asList(mapper.readValue(request, FlowerRequest[].class));
			Predicate<FlowerRequest> p1 = obj -> obj.getUserId() == 1;
			Predicate<FlowerRequest> p2 = obj -> obj.getId() == 4;
			flowerRequestList.stream().filter(p1.and(p2)).peek(o -> o.setTitle("1800Flowers"))
					.forEach(o -> o.setBody("1800Flowers"));

		}
		return flowerRequestList;

	}
	public List<FlowerResponse> getAllUserIds(String request) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Integer> userIdList = new ArrayList<>();
		List<FlowerResponse> flowerResponseList = new ArrayList<>();
		try {
			if (!request.isBlank()) {
				List<FlowerRequest> flowerRequestList = Arrays.asList(mapper.readValue(request, FlowerRequest[].class));
				userIdList = flowerRequestList.stream().map(FlowerRequest::getUserId).distinct()
						.collect(Collectors.toList());
				for (Integer user : userIdList) {
					int count = 0;
					for (FlowerRequest requestItem : flowerRequestList) {
						if (user == requestItem.getUserId()) {
							count++;
						}
					}
					FlowerResponse flowerResponse = new FlowerResponse();
					flowerResponse.setUserId(user);
					flowerResponse.setCount(count);
					flowerResponseList.add(flowerResponse);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return flowerResponseList;
	}


	@Override
	public List<FlowerRequest> modifyRequestById(String request, int id) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<FlowerRequest> flowerRequestList = new ArrayList<>();
		boolean flag= false;
		if (!request.isBlank()) {
			flowerRequestList = Arrays.asList(mapper.readValue(request, FlowerRequest[].class));
			if(flowerRequestList.size()>=id) {
				flowerRequestList.get(id-1).setBody("1800Flowers");
				flowerRequestList.get(id-1).setTitle("1800Flowers");
				flag=true;
			}
			
			if(!flag) {
				throw new Exception("Reuested element is not found.Please try again..");
			}

		}
		return flowerRequestList;
	}

}
