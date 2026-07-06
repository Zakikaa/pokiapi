package com.pokefight.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokefight.dto.FightResult;
import com.pokefight.dto.Poke;
import com.pokefight.service.FightLogService;
import com.pokefight.service.PokeCacheService;
import com.pokefight.util.PokeType;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PokeFightController {
	@Autowired
	private final PokeCacheService cacheService;
	
	@Autowired
	private final FightLogService fightLogService;
	
	
	public PokeFightController(PokeCacheService cacheService, FightLogService fightLogService) {
		  this.cacheService = cacheService;
		  this.fightLogService = fightLogService;
	}
	

	@PostMapping("/fight")
	public int fight(@RequestParam int id, @RequestParam int id2) {
		Random r= new Random();

		Poke pokemon1 = cacheService.getPokemon(id);
		Poke pokemon2 = cacheService.getPokemon(id2);

		int power1 = (int) (PokeType.getMultiplier(pokemon1.getType(), pokemon2.getType()) * (r.nextInt(19) + 1));
		int power2 = (int) (PokeType.getMultiplier(pokemon2.getType(), pokemon1.getType()) * (r.nextInt(19) + 1));

		Poke winnerPokemon;
		if(power2 > power1) {
			winnerPokemon = pokemon2;
		} else 	{
			winnerPokemon = pokemon1;
		}
		
		FightResult result = new FightResult(pokemon1,pokemon2, winnerPokemon);
		fightLogService.add(result);

		return winnerPokemon.getId();
	}
}
