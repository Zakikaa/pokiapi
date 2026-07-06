package com.pokefight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokefight.dto.FightResult;
import com.pokefight.service.FightLogService;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController  {

    @Autowired
    private FightLogService fightLogService;

	public HistoryController(FightLogService fightLogService) {
		this.fightLogService = fightLogService;
	}

    @GetMapping
    public List<FightResult> getHistory() {
        return fightLogService.getHistory();
    }
}

