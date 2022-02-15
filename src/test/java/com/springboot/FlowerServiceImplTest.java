package com.springboot;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springboot.service.impl.FlowerServiceImpl;

@ExtendWith(SpringExtension.class)
@AssertTrue
public class FlowerServiceImplTest {

	@InjectMocks
	private FlowerServiceImpl flowerServiceImpl;

	@Test
	public void testGetAllUserIds() throws Exception {
		 String request = " [{\r\n"
	        		+ "    \"userId\": 1,\r\n"
	        		+ "    \"id\": 1,\r\n"
	        		+ "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\r\n"
	        		+ "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n"
	        		+ "  },\r\n"
	        		+ "  {\r\n"
	        		+ "    \"userId\": 1,\r\n"
	        		+ "    \"id\": 4,\r\n"
	        		+ "    \"title\": \"qui est esse\",\r\n"
	        		+ "    \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\r\n"
	        		+ "  }\r\n"
	        		+ "]";
		flowerServiceImpl.getAllUserIds(request);

	}


	@Test
	public void testModifyRequest() throws Exception {
		String request = " [{\r\n"
        		+ "    \"userId\": 1,\r\n"
        		+ "    \"id\": 1,\r\n"
        		+ "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\r\n"
        		+ "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n"
        		+ "  },\r\n"
        		+ "  {\r\n"
        		+ "    \"userId\": 1,\r\n"
        		+ "    \"id\": 4,\r\n"
        		+ "    \"title\": \"qui est esse\",\r\n"
        		+ "    \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\r\n"
        		+ "  }\r\n"
        		+ "]";
		flowerServiceImpl.modifyRequest(request);
	}
	
	@Test
	public void testModifyRequestById() throws Exception {
		String request = " [{\r\n"
        		+ "    \"userId\": 1,\r\n"
        		+ "    \"id\": 1,\r\n"
        		+ "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\r\n"
        		+ "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n"
        		+ "  },\r\n"
        		+ "  {\r\n"
        		+ "    \"userId\": 1,\r\n"
        		+ "    \"id\": 4,\r\n"
        		+ "    \"title\": \"qui est esse\",\r\n"
        		+ "    \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\r\n"
        		+ "  }\r\n"
        		+ "]";
		flowerServiceImpl.modifyRequestById(request, 1);
	}
	

}
