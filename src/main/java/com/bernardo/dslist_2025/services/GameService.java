package com.bernardo.dslist_2025.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bernardo.dslist_2025.dto.GameDTO;
import com.bernardo.dslist_2025.dto.GameMinDTO;
import com.bernardo.dslist_2025.entities.Game;
import com.bernardo.dslist_2025.repositories.GameRepository;



@Service
public class GameService {
	
	// service injeta o repository
	@Autowired
	private GameRepository gameRepository;
	
	// retorna apenas 1 jogo
	@Transactional(readOnly = true)
	public GameDTO findById(Long gameId) {
		Game result = gameRepository.findById(gameId).get();
		// verificasr a forma de tratgar erro 
		// qdo nao houver o parametro do jjogo passado
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	// service retorna sempre DTO
	@Transactional(readOnly = true) // controla para nao travar o banco durante a consulta: org.springframework.transaction.annotation.Transactional
	public List<GameMinDTO> findAll(){
		// cria variavel tipo list game
		List<Game> result = gameRepository.findAll();
		// convertendo o retorno da tabela completa game para gameDTO
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}

}
