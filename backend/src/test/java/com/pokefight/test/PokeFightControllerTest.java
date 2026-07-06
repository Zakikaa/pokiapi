package com.pokefight.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pokefight.controller.PokeFightController;
import com.pokefight.dto.Poke;
import com.pokefight.service.FightLogService;
import com.pokefight.service.PokeApiService;
import com.pokefight.service.PokeCacheService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.pokefight.util.PokeType.Type;

@WebMvcTest(PokeFightController.class)
public class PokeFightControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private FightLogService fightLogService;

    @MockBean
    private PokeCacheService cacheService;
    
    @MockBean
    private PokeApiService pokeApiService;


    @Test
    void testPokeFightEndpoint() throws Exception {
    	
        Poke poke1 = new Poke(1, "Bulbasaur", Type.GRASS, "sprite");
        Poke poke2 = new Poke(2, "Charmander", Type.FIRE, "sprite");

        when(cacheService.getPokemon(1)).thenReturn(poke1);
        when(cacheService.getPokemon(2)).thenReturn(poke2);
     
        mockMvc.perform(post("/api/fight")
	        .param("id", "1")
	        .param("id2", "2"))
	        .andExpect(status().isOk());
}
}

