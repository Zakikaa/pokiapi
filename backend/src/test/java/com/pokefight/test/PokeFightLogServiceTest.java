package com.pokefight.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.pokefight.dto.FightResult;
import com.pokefight.dto.Poke;
import com.pokefight.service.FightLogService;
import com.pokefight.util.PokeType.Type;

public class PokeFightLogServiceTest {

    private final FightLogService fightLogService = new FightLogService();

    @Test
    void testFightLogHistory() {
        Poke pokemon1 = new Poke(1, "Charmander", Type.FIRE, "sprite");
        Poke pokemon2 = new Poke(2, "Bulbasaur", Type.GRASS, "sprite");

        FightResult result = new FightResult(pokemon1,pokemon2, pokemon1);
		fightLogService.add(result);
		
        assertEquals(1, fightLogService.getHistory().size());
    }
}