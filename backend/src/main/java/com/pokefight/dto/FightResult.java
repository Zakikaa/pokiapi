package com.pokefight.dto;

import java.util.Date;

public class FightResult {
	private String first;
    private String second;
    private String winner;
    private Date timestamp;

    public FightResult(Poke first, Poke second, Poke winner) {
        this.first = first.getName();
        this.second = second.getName();
        this.winner = winner.getName();;
        this.timestamp = new Date();
    }

    public String getFirst() { return first; }
    public String getSecond() { return second; }
    public String getWinner() { return winner; }
    public Date getTimestamp() { return timestamp; }
}
