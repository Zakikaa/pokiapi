package com.pokefight.dto;

import java.util.Date;

public class FightResult {
	private Poke first;
    private Poke second;
    private Poke winner;
    private Date timestamp;

    public FightResult(Poke first, Poke second, Poke winner) {
        this.first = first;
        this.second = second;
        this.winner = winner;
        this.timestamp = new Date();
    }

    public Poke getFirst() { return first; }
    public Poke getSecond() { return second; }
    public Poke getWinner() { return winner; }
    public Date getTimestamp() { return timestamp; }
}
