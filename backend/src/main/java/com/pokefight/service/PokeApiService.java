package com.pokefight.service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pokefight.dto.Poke;

import org.json.JSONObject;

@RestController
public class PokeApiService {
	String baseUrl = "https://pokeapi.co/api/v2/";
	private final RestTemplate restTemplate = new RestTemplate();
	
	public Poke fetchPokemonJson(int pokemonId) {
      Poke response = restTemplate.getForObject(baseUrl + "/pokemon/" + pokemonId, Poke.class);

      return response;
      
  }
  
	public int fetchPokemonCount() {

	String url = baseUrl + "pokemon?limit=10000&offset=0";
	String json = restTemplate.getForObject(url, String.class);
	JSONObject obj = new JSONObject(json);

	return obj.getInt("count"); 
  }
}
