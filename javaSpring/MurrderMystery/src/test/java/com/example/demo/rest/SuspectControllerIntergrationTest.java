
package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.data.Suspect;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

@Sql(scripts = { "classpath:Suspect-schema.sql",
		"classpath:Suspect-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SuspectControllerIntergrationTest {

	@Autowired // tells Spring to inject the MockMVC object into this class
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper; // yanks the class Spring uses to convert java to JSON

	@Test
	void testCreate() throws Exception {
		Suspect testpro = new Suspect("jordan","gun","bedroom","teacher","50%");
		String testproAsJSON = mapper.writeValueAsString(testpro);

		System.out.println(testpro);
		System.out.println(testpro);

		RequestBuilder request = post("/createSuspect").contentType(MediaType.APPLICATION_JSON).content(testproAsJSON);

		ResultMatcher checkStatus = status().is(201);

		Suspect testSuspect = new Suspect("jordan","gun","bedroom","teacher","50%");
		testSuspect.setId(2); // due to the AUTO_INCREMENT
		String testSuspectAsJSON = this.mapper.writeValueAsString(testSuspect);

		ResultMatcher checkBody = content().json(testSuspectAsJSON);
// SEND request and check status + body
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		// create request
		RequestBuilder request = delete("/deleteSuspect/1");

		// check response
		ResultMatcher checkStatus = status().is(204);
		ResultMatcher checkBody = content().string("Deleted: 1");

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testProjectList() throws Exception {
		// create request
		RequestBuilder request = get("/getSuspects");

		// check response
		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus);
	}

	@Test
	void testProject() throws Exception { // create request RequestBuilder

		Suspect testSuspect = new Suspect("jordan","gun","bedroom","teacher","50%");
		testSuspect.setId(1); // due to the AUTO_INCREMENT
		String testSuspectAsJSON = this.mapper.writeValueAsString(testSuspect);

		ResultMatcher checkBody = content().json(testSuspectAsJSON);
		RequestBuilder request = get("/getProject/1");
		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testProjectByName() throws Exception { // create request RequestBuilder
		Suspect testName = new Suspect("jordan","gun","bedroom","teacher","50%");
		testName.setId(1); // due to the AUTO_INCREMENT
		String help = this.mapper.writeValueAsString(testName);
		System.out.println(help);
		ResultMatcher checkBody = content().json(help);

		RequestBuilder request = get("/getByName/jordan");
		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		int id = 1;
		Suspect project = new Suspect(id,"jordan","gun","bedroom","teacher","50%");
		String project1 = this.mapper.writeValueAsString(project);
		RequestBuilder request = put("/updateProject/1").contentType(MediaType.APPLICATION_JSON).content(project1);
		ResultMatcher checkBody = content().json(project1);
		ResultMatcher checkStatus = status().is(200);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
}

