package com.nabin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nabin.spring.mockito.model.Employee;
import com.nabin.spring.mockito.model.Response;


@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringmvcMockitoMockmvcExampleApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om = new ObjectMapper();
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void addEmployeeTest() throws Exception {
		Employee emp = new Employee();
		emp.setName("Nabin");
		emp.setDept("IT");
		String jsonRequest = om.writeValueAsString(emp);
		MvcResult mvcResult = mockMvc.perform(post("/addEmployee").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
		String resultContent = mvcResult.getResponse().getContentAsString();
		Response response = om.readValue(resultContent, Response.class);
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
	}
	

}
