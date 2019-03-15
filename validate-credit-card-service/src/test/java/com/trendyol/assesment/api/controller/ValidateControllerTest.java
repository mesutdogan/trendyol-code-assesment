package com.trendyol.assesment.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendyol.assesment.api.domain.ValidateCreditCardRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
public class ValidateControllerTest {

	private MockMvc mvc;

	@InjectMocks
	private ValidateCreditCardController superHeroController;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		// MockMvc standalone approach
		mvc = MockMvcBuilders.standaloneSetup(superHeroController)
				.build();
	}

	@Test
	public void whenRequestIsSentCorrectly_thenShouldReturnHttp200() throws Exception {

		MockHttpServletResponse response = mvc.perform(
				post("/credit-card/validate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(new ValidateCreditCardRequest()))
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

	}

	@Test
	public void whenUrlIsInCorrect_thenShouldReturnHttp404() throws Exception {

		MockHttpServletResponse response = mvc.perform(
				post("/wrong-uri")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(new ValidateCreditCardRequest()))
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());

	}

	@Test
	public void whenContentTypeHeaderIsNotJson_thenShouldReturnHttp415() throws Exception {

		MockHttpServletResponse response = mvc.perform(
				post("/credit-card/validate")
						.contentType(MediaType.APPLICATION_XML)
						.content(new ObjectMapper().writeValueAsString(new ValidateCreditCardRequest()))
						.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());

	}

	@Test
	public void whenUrlAcceptHeaderIsNotJson_thenShouldReturnHttp415() throws Exception {

		MockHttpServletResponse response = mvc.perform(
				post("/credit-card/validate")
						.contentType(MediaType.APPLICATION_XML)
						.content(new ObjectMapper().writeValueAsString(new ValidateCreditCardRequest()))
						.accept(MediaType.APPLICATION_PDF))
				.andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());

	}
}
