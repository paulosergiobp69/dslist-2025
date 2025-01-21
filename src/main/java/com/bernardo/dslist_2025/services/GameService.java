package com.bernardo.dslist_2025.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardo.dslist_2025.dto.GameMinDTO;
import com.bernardo.dslist_2025.entities.Game;
import com.bernardo.dslist_2025.repositories.GameRepository;

@Service
public class GameService {
	
	// service injeta o repository
	@Autowired
	private GameRepository gameRepository;
	
	
	// service retorna sempre DTO
	public List<GameMinDTO> findAll(){
		// cria variavel tipo list game
		List<Game> result = gameRepository.findAll();
		// convertendo o retorno da tabela completa game para gameDTO
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}

}
