package com.restfullapi.musicapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullapi.musicapi.entity.Album;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {

}

