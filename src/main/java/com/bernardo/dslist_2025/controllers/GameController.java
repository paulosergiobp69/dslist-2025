package com.bernardo.dslist_2025.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.dslist_2025.dto.GameDTO;
import com.bernardo.dslist_2025.dto.GameMinDTO;
import com.bernardo.dslist_2025.services.GameService;

// 1 define tipo e endpoint
@RestController
@RequestMapping(value="/games")
public class GameController {
	
	// controller injeta o service
	@Autowired
	private GameService gameService;

	// define tipo de classe para retorno
	@GetMapping(value = "/{gameId}")
	public GameDTO findById(@PathVariable Long gameId){
		GameDTO result = gameService.findById(gameId);
		return result;
	}

	// define tipo de classe para retorno
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	

}
