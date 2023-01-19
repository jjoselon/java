package com.restfullapi.musicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfullapi.musicapi.entity.Album;
import com.restfullapi.musicapi.service.IAlbumsService;

@RestController
@RequestMapping("/api")
public class AlbumController {
	
	/* Para inyectar una instancia de una clase que implemente IAlbumsService. Usamos @Autowired*/
	@Autowired
	private IAlbumsService serviceAlbums;
	
	@GetMapping("/albums")
	public List<Album> buscarTodas() {
		return serviceAlbums.buscarTodas();
	}
	
	@PostMapping("/albums")
	public Album guardar(@RequestBody Album album) {
		// Con la anotacion @RequestBody le indicamos que en el cuerpo de esta petición la informacion
		// que venga en formato json y debe realizar en Data Binding de forma automatica a un objecto
		// de tipo Album. De esa forma ya el campo album estara listo.
		serviceAlbums.guardar(album);
		return album;
	}
	
	@PutMapping("/albums")
	public Album modificar(@RequestBody Album album) {
		serviceAlbums.guardar(album);
		return album;
	}
	
	@DeleteMapping("/albums/{id}")
	public String eliminar(@PathVariable("id") int idAlbum) {
		// {id} lo mapeamos a nuestra variable idAlbum con @PathVariable
		serviceAlbums.eliminar(idAlbum);
		return "Registo eliminado";
	}
}