package com.bernardo.dslist_2025.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bernardo.dslist_2025.dto.GameListDTO;
import com.bernardo.dslist_2025.entities.GameList;
import com.bernardo.dslist_2025.repositories.GameListRepository;



@Service
public class GameListService {
	
	// service injeta o repository
	@Autowired
	private GameListRepository gameListRepository;
	
	// retorna apenas 1 jogo
	@Transactional(readOnly = true)
	public GameListDTO findById(Long gameId) {
		GameList result = gameListRepository.findById(gameId).get();
		// verificasr a forma de tratgar erro 
		// qdo nao houver o parametro do jjogo passado
		GameListDTO dto = new GameListDTO(result);
		return dto;
	}
	
	// service retorna sempre DTO
	@Transactional(readOnly = true) // controla para nao travar o banco durante a consulta: org.springframework.transaction.annotation.Transactional
	public List<GameListDTO> findAll(){
		// cria variavel tipo list game
		List<GameList> result = gameListRepository.findAll();
		// convertendo o retorno da tabela completa game para gameDTO
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
		
	}

}
