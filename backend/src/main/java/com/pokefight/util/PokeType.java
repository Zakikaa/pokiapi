package com.pokefight.util;

import java.util.*;

public class PokeType {

	public enum Type {
	    NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG,
	    GHOST, STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC,
	    ICE, DRAGON, DARK, FAIRY, STELLAR;
	}
	
    private static final Map<Type, Map<Type, Double>> chart = new HashMap<>();

    static {

        chart.put(Type.NORMAL, Map.of(
                Type.ROCK, 0.5,
                Type.STEEL, 0.5,
                Type.GHOST, 0.0
        ));

        chart.put(Type.FIRE, Map.of(
                Type.GRASS, 2.0,
                Type.ICE, 2.0,
                Type.BUG, 2.0,
                Type.STEEL, 2.0,
                Type.FIRE, 0.5,
                Type.WATER, 0.5,
                Type.ROCK, 0.5,
                Type.DRAGON, 0.5
        ));

        chart.put(Type.WATER, Map.of(
                Type.FIRE, 2.0,
                Type.GROUND, 2.0,
                Type.ROCK, 2.0,
                Type.WATER, 0.5,
                Type.GRASS, 0.5,
                Type.DRAGON, 0.5
        ));

        chart.put(Type.GRASS, Map.of(
                Type.WATER, 2.0,
                Type.GROUND, 2.0,
                Type.ROCK, 2.0,
                Type.FIRE, 0.5,
                Type.GRASS, 0.5,
                Type.POISON, 0.5,
                Type.FLYING, 0.5,
                Type.BUG, 0.5,
                Type.DRAGON, 0.5,
                Type.STEEL, 0.5
        ));

        chart.put(Type.ELECTRIC, Map.of(
                Type.WATER, 2.0,
                Type.FLYING, 2.0,
                Type.GRASS, 0.5,
                Type.ELECTRIC, 0.5,
                Type.DRAGON, 0.5,
                Type.GROUND, 0.0
        ));

        chart.put(Type.ICE, Map.of(
                Type.GRASS, 2.0,
                Type.GROUND, 2.0,
                Type.FLYING, 2.0,
                Type.DRAGON, 2.0,
                Type.FIRE, 0.5,
                Type.WATER, 0.5,
                Type.ICE, 0.5,
                Type.STEEL, 0.5
        ));


        chart.put(Type.FIGHTING, Map.of(
                Type.NORMAL, 2.0,
                Type.ICE, 2.0,
                Type.ROCK, 2.0,
                Type.DARK, 2.0,
                Type.STEEL, 2.0,
                Type.POISON, 0.5,
                Type.FLYING, 0.5,
                Type.PSYCHIC, 0.5,
                Type.BUG, 0.5,
                Type.FAIRY, 0.5
        ));
        
        chart.put(Type.POISON, Map.of(
                Type.GRASS, 2.0,
                Type.FAIRY, 2.0,
                Type.POISON, 0.5,
                Type.GROUND, 0.5,
                Type.ROCK, 0.5,
                Type.GHOST, 0.5,
                Type.STEEL, 0.0
        ));

        chart.put(Type.GROUND, Map.of(
                Type.FIRE, 2.0,
                Type.ELECTRIC, 2.0,
                Type.POISON, 2.0,
                Type.ROCK, 2.0,
                Type.STEEL, 2.0,
                Type.GRASS, 0.5,
                Type.BUG, 0.5,
                Type.FLYING, 0.0
        ));

        chart.put(Type.FLYING, Map.of(
                Type.GRASS, 2.0,
                Type.FIGHTING, 2.0,
                Type.BUG, 2.0,
                Type.ELECTRIC, 0.5,
                Type.ROCK, 0.5,
                Type.STEEL, 0.5
        ));

        chart.put(Type.PSYCHIC, Map.of(
                Type.FIGHTING, 2.0,
                Type.POISON, 2.0,
                Type.PSYCHIC, 0.5,
                Type.STEEL, 0.5,
                Type.DARK, 0.0
        ));

        chart.put(Type.BUG, Map.of(
                Type.GRASS, 2.0,
                Type.PSYCHIC, 2.0,
                Type.DARK, 2.0,
                Type.FIRE, 0.5,
                Type.FIGHTING, 0.5,
                Type.POISON, 0.5,
                Type.FLYING, 0.5,
                Type.GHOST, 0.5,
                Type.STEEL, 0.5,
                Type.FAIRY, 0.5
        ));

        chart.put(Type.ROCK, Map.of(
                Type.FIRE, 2.0,
                Type.ICE, 2.0,
                Type.FLYING, 2.0,
                Type.BUG, 2.0,
                Type.FIGHTING, 0.5,
                Type.GROUND, 0.5,
                Type.STEEL, 0.5
        ));

        chart.put(Type.GHOST, Map.of(
                Type.PSYCHIC, 2.0,
                Type.GHOST, 2.0,
                Type.DARK, 0.5,
                Type.NORMAL, 0.0
        ));

        chart.put(Type.DRAGON, Map.of(
                Type.DRAGON, 2.0,
                Type.STEEL, 0.5,
                Type.FAIRY, 0.0
        ));

        chart.put(Type.DARK, Map.of(
                Type.PSYCHIC, 2.0,
                Type.GHOST, 2.0,
                Type.FIGHTING, 0.5,
                Type.DARK, 0.5,
                Type.FAIRY, 0.5
        ));

        chart.put(Type.STEEL, Map.of(
                Type.ICE, 2.0,
                Type.ROCK, 2.0,
                Type.FAIRY, 2.0,
                Type.FIRE, 0.5,
                Type.WATER, 0.5,
                Type.ELECTRIC, 0.5,
                Type.STEEL, 0.5
        ));

        chart.put(Type.FAIRY, Map.of(
                Type.FIGHTING, 2.0,
                Type.DRAGON, 2.0,
                Type.DARK, 2.0,
                Type.FIRE, 0.5,
                Type.POISON, 0.5,
                Type.STEEL, 0.5
        ));
    }

    public static double getMultiplier(Type attack, Type defense) {
        return chart.getOrDefault(attack, Collections.emptyMap())
                    .getOrDefault(defense, 1.0);
    }
}