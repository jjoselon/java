package com.restfullapi.musicapi.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfullapi.musicapi.entity.Album;
import com.restfullapi.musicapi.repository.AlbumsRepository;
import com.restfullapi.musicapi.service.IAlbumsService;

@Service
public class AlbumService implements IAlbumsService {
	
	/* Con @Autowired le indicamos que en 'albumsRepo' se inyectara una instancia de nuestro repositorio, es decir la(s) clase(s) que implementen esta interfaz. En este caso seria el core de spring jpa*/
	@Autowired
	private AlbumsRepository albumsRepo;
	/* Para la implementación de nuestros métodos de interfaz es decir su lógica. Vamos a usar AlbumsRepository */

	@Override
	public List<Album> buscarTodas() {
		return albumsRepo.findAll();
	}

	@Override
	public void guardar(Album album) {
		albumsRepo.save(album);
	}

	@Override
	public void eliminar(int idAlbum) {
		albumsRepo.deleteById(idAlbum);
	}

}

