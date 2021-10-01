package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	private static final String TEST1 = "/prices/1/35455?date=2020-06-14T10:00:00";
	private static final String TEST2 = "/prices/1/35455?date=2020-06-14T16:00:00";
	private static final String TEST3 = "/prices/1/35455?date=2020-06-14T21:00:00";
	private static final String TEST4 = "/prices/1/35455?date=2020-06-15T10:00:00";
	private static final String TEST5 = "/prices/1/35455?date=2020-06-16T21:00:00";
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void test1() throws Exception {
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get(TEST1)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.5));
		
	}
	
	@Test
	void test2() throws Exception {

		mockMvc.perform( MockMvcRequestBuilders
			      .get(TEST2)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
		
	}
	
	@Test
	void test3() throws Exception {

		mockMvc.perform( MockMvcRequestBuilders
			      .get(TEST3)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
		
	}
	
	@Test
	void test4() throws Exception {

		mockMvc.perform( MockMvcRequestBuilders
			      .get(TEST4)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.5));
		
	}
	
	@Test
	void test5() throws Exception {

		mockMvc.perform( MockMvcRequestBuilders
			      .get(TEST5)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(print())
			      .andExpect(status().isOk())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));
		
	}
}
