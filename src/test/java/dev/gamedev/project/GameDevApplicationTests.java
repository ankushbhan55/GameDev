package dev.gamedev.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.gamedev.project.model.GamePlayerLevelLink;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameDevApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private MockHttpServletResponse response;

	@Test
	public void getAllPlayersTest() throws Exception {
		response = this.mockMvc.perform(get("/api/players"))
				.andDo(print())
				.andReturn().getResponse();

		String content = response.getContentAsString();

		// Use ObjectMapper to deserialize the JSON response
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, String>> players = objectMapper.readValue(content, new TypeReference<List<Map<String, String>>>() {});

		// Assert player names
		assertEquals("Ankush Bhan", players.get(0).get("name"));
		assertEquals("ShruB", players.get(1).get("name"));
	}

	@Test
	public void assignInvalidGameToPlayerTest() throws Exception {

		GamePlayerLevelLink gll = new GamePlayerLevelLink();
		gll.setGameName("Diablo");
		gll.setPlayerEmail("shrub@gmail.com");
		gll.setLevel("pro");

		String json = mapper.writeValueAsString(gll);

		response = this.mockMvc.perform(post("/api/players/linkgameswithplayers").
				contentType(MediaType.APPLICATION_JSON)
				.content(json).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();



		assertEquals("Diablo does not exist in database", response.getContentAsString());

		mockMvc.perform(post("/api/players/linkgameswithplayers").contentType(MediaType.APPLICATION_JSON)
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

	}

	@Test
	void testLinkGamesWithPlayer() throws Exception{
		GamePlayerLevelLink gll = new GamePlayerLevelLink();
		gll.setGameName("Fortnite");
		gll.setPlayerEmail("shrub@gmail.com");
		gll.setLevel("pro");

		String json = mapper.writeValueAsString(gll);
		mockMvc.perform(post("/api/players/linkgameswithplayers").contentType(MediaType.APPLICATION_JSON)
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
}
