package com.bernardo.dslist_2025.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardo.dslist_2025.dto.GameListDTO;
import com.bernardo.dslist_2025.dto.GameMinDTO;
import com.bernardo.dslist_2025.services.GameListService;
import com.bernardo.dslist_2025.services.GameService;

// 1 define tipo e endpoint
@RestController
@RequestMapping(value="/lists")
public class GameListController {
	
	// controller injeta o service
	@Autowired
	private GameListService gameListService;

	@Autowired
	private GameService gameService;


	// define tipo de classe para retorno
	@GetMapping(value = "/{gameId}")
	public GameListDTO findById(@PathVariable Long gameId){
		GameListDTO result = gameListService.findById(gameId);
		return result;
	}

	// define tipo de classe para retorno
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	// define tipo de classe para retorno
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}

}
