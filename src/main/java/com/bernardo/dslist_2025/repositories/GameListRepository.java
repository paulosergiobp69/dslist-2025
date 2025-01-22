package com.bernardo.dslist_2025.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardo.dslist_2025.entities.GameList;

// estancia a inferface JPAREPOSITORY
// importa JpaRepository com ctrl + ashift + O
// passando como parametro a entity é o tipo da PK : 	private Long id;]
// camada de acesso a dados
public interface GameListRepository extends JpaRepository<GameList, Long> {

}
