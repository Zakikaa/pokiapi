package com.pokefight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pokefight.dto.FightResult;

@Service
public class FightLogService {

	    private final List<FightResult> history = new ArrayList<>();

	    public void add(FightResult result) {
	        history.add(result);
	    }

	    public List<FightResult> getHistory() {
	        return history;
	    }
}
