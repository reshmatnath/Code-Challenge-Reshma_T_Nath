package com.springboot;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.InstanceNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springboot.controller.FlowerController;
import com.springboot.model.FlowerRequest;
import com.springboot.model.FlowerResponse;
import com.springboot.service.FlowerService;

@ExtendWith(SpringExtension.class)
public class FlowerControllerTest {

	@InjectMocks
	private FlowerController flowerController;
	
	@Mock
	private FlowerService flowerServices;
	
	@Test
	public void testGetAllUserIdCount() throws IOException
	{
		Map<String,Long> result = new HashMap<>();
		result.put("test", 2L);
		when(flowerServices.getAllUserIdCount(Mockito.anyString())).thenReturn(result);
		flowerController.getAllUserIdCount(Mockito.anyString());
	}
	
	@Test
	public void testGetAllUserIds() throws IOException
	{
		List<FlowerResponse> result = new ArrayList<>();
		when(flowerServices.getAllUserIds(Mockito.anyString())).thenReturn(result);
		flowerController.getAllUserIds(Mockito.anyString());
	}
	
	@Test
	public void testModifyRequest() throws IOException, JSONException
	{
		List<FlowerRequest> result = new ArrayList<>();
		when(flowerServices.modifyRequest(Mockito.anyString())).thenReturn(result);
		flowerController.modifyRequest(Mockito.anyString());
	}
	
	@Test
	public void testModifyRequestById() throws InstanceNotFoundException, Exception
	{
		List<FlowerRequest> result = new ArrayList<>();
		when(flowerServices.modifyRequestById(Mockito.anyString(),Mockito.anyInt())).thenReturn(result);
		flowerController.modifyRequestById(Mockito.anyInt(), Mockito.anyString());
	}
}
