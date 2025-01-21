package com.bernardo.dslist_2025.dto;

import com.bernardo.dslist_2025.entities.Game;

public class GameMinDTO {

	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	
	// 1. cria construtor
	public GameMinDTO() {
		
	}

	// 2. cria construtor com argumentos
	// source ->  generate contructor using fields
	// altera para tratar apenas receber a entidade e importa a entidade
	// public GameMinDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {
	// importa a classe game: ctrl + shift + o (game)
	// pode ate apagar o "this." se quiser eu deixei por gosto
	public GameMinDTO(Game entity) {
		// super(); 
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}

	// 3. importa os gets
	// source generate gets e sets seleciona apenas os gets
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
	
	
	
}
