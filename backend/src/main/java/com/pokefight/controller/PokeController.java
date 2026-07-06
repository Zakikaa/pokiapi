package com.pokefight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokefight.dto.Poke;
import com.pokefight.service.PokeCacheService;

@RestController
@RequestMapping("/api/poke")
@CrossOrigin(origins = "http://localhost:4200")
public class PokeController {

    @Autowired
    private PokeCacheService pokemonService;

	public PokeController(PokeCacheService pokemonService) {
		  this.pokemonService = pokemonService;
	}
	
    @GetMapping("/{id}")
    public Poke getPokemon(@PathVariable int id) {
        return pokemonService.getPokemon(id);
    }

}

