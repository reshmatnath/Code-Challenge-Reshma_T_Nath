package com.springboot;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springboot.controller.FlowerController;

@RunWith(SpringJUnit4ClassRunner.class)
public class FlowerControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private FlowerController flowerController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(flowerController)
                .build();
    }

   
    @Test
    public void testGetAllUserIds() throws Exception {
        String json = " [{\r\n"
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
        		
        mockMvc.perform(post("/getAllUserIds")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
    
    @Test(expected = Exception.class)
    public void testGetAllUserIdsException() throws Exception {
        String json = " [{\r\n"
        		+ "    \"id\": 1,\r\n"
        		+ "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\r\n"
        		+ "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n"
        		+ "  },"
        		+ "]";
        		
        mockMvc.perform(post("/getAllUserIds")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isExpectationFailed());
    }

    @Test
    public void testModifyRequest() throws Exception {
        String json = " [{\r\n"
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
        		
        mockMvc.perform(post("/modifyRequest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}