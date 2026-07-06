package com.pokefight.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokefight.dto.Poke;

@Service
public class PokeCacheService {

    @Autowired
    private PokeApiService externalApiService;
    private final Map<Integer, Poke> cache = new HashMap<>();
    private int pokemonCount = -1;

    public Poke getPokemon(int id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }

        Poke p = externalApiService.fetchPokemonJson(id);
        cache.put(id, p);
        return p;
    }
    
    public int getPokemonCount() {
        if (pokemonCount > 0) {
            return pokemonCount;
        }
        
        pokemonCount = externalApiService.fetchPokemonCount();
        return pokemonCount;
    }
}
