package com.bae.cats.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

import com.bae.cats.domain.Cat;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:cat-schema.sql",
		"classpath:cat-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CatControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Cat testCat = new Cat(400d, "yes", "Fluffer");
		String testCatAsJSON = this.mapper.writeValueAsString(testCat);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testCatAsJSON);

		Cat testCreatedCat = new Cat(2, 400d, "yes", "Fluffer");
		String testCreatedCatAsJSON = this.mapper.writeValueAsString(testCreatedCat);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedCatAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetCats() throws Exception {
		RequestBuilder req = get("/get");

		List<Cat> testAllCats = List.of(new Cat(1, 400d, "yes", "Fluffer"));
		String testAllCatsAsJSON = this.mapper.writeValueAsString(testAllCats);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testAllCatsAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetCatById() throws Exception {
		Cat testCat = new Cat(1, 400d, "yes", "Fluffer");
		String JSON = this.mapper.writeValueAsString(testCat);
		RequestBuilder req = get("/get/1");

		ResultMatcher checkStatus = status().is2xxSuccessful();
		ResultMatcher checkBody = content().json(JSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdateCat() throws Exception {
		Cat testCat = new Cat(400d, "yes", "Fluffer");
		String testCatAsJSON = this.mapper.writeValueAsString(testCat);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testCatAsJSON);

		Cat testCreatedCat = new Cat(1, 400d, "yes", "Fluffer");
		String testCreatedCatAsJSON = this.mapper.writeValueAsString(testCreatedCat);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testCreatedCatAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDeleteCat() throws Exception {
		this.mvc.perform(delete("/remove/1")).andExpect(status().isNoContent());
	}
}
