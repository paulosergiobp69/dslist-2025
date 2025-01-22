package com.bernardo.dslist_2025.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bernardo.dslist_2025.entities.Game;
import com.bernardo.dslist_2025.projections.GameMinProjection;

// estancia a inferface JPAREPOSITORY
// importa JpaRepository com ctrl + ashift + O
// passando como parametro a entity é o tipo da PK : 	private Long id;]
// camada de acesso a dados
public interface GameRepository extends JpaRepository<Game, Long> {

	@Query(nativeQuery = true, 
			value = "SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear,"
				  + " tb_game.img_url AS imgUrl,tb_game.short_description AS shortDescription, "
				  + "tb_belonging.position FROM tb_game "
				  + " INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id 	"
				  + " WHERE tb_belonging.list_id = :listId "
				  + " ORDER BY tb_belonging.position")
	List<GameMinProjection> searchByList(Long listId);
	
}
