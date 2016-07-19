package com_spring_core11_restclient;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import com_spring_core11_restclient.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/spring11-1.xml" })
public class HomeControllerTest {

	private MockMvc mockMvc;
	private RestTemplate restTemplate;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
				.build();
		this.restTemplate = new RestTemplate(
				new MockMvcClientHttpRequestFactory(mockMvc));
	}

	@Test
	public void testGetABC() {

		String result = restTemplate
				.getForObject("/getabc?ab=ab", String.class);
		assertTrue("abc".equals(result));

	}

	@Test
	public void testPostABC() throws IOException {

		// String resquestcheck = "{\"ab\":\"ab\"}";
		/*HttpHeaders headerscheck = new HttpHeaders();
		headerscheck.setContentType(MediaType.MULTIPART_FORM_DATA);

		File file = new File(
				"D:/ANDROI/Util.cn1lib");
		// HttpEntity<String> httpEntitycheck = new
		// HttpEntity<String>(resquestcheck, headerscheck);
		
		byte[] resquestcheck = Files.readAllBytes(Paths.get(file.getPath()));
		
		HttpEntity<Object> httpEntitycheck = new HttpEntity<Object>(
				resquestcheck,
				headerscheck);
		String result = restTemplate.postForObject("/postabc", httpEntitycheck,
				String.class);

		assertTrue("c".equals(result));*/
	}

	@Test
	public void testcusumes(){
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		 * 
		 * HttpEntity<Object> httpEntity = new HttpEntity<Object>("", headers);
		 * 
		 * restTemplate.postForObject("/testconsumes", httpEntity, void.class);
		 */
	}
}
