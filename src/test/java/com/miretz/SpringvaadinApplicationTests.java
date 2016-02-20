package com.miretz;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringvaadinApplication.class)
@WebAppConfiguration
public class SpringvaadinApplicationTests {

	private final MediaType mediaType = MediaType.parseMediaType("application/hal+json");
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void before() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
    public void contextLoads() throws Exception {
    	this.mockMvc.perform(get("/reservations").accept(this.mediaType)).andExpect(content().contentType(this.mediaType)).andExpect(status().isOk());
    }

}
