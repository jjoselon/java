package com.restfullapi.musicapi.service;

import java.util.List;

import com.restfullapi.musicapi.entity.Album;

public interface IAlbumsService {
	List<Album> buscarTodas();
	void guardar(Album album);
	void eliminar(int idAlbum);
	
}

