package com.gamesmall.jpa.intro.jpaintro.repositories;

import com.gamesmall.jpa.intro.jpaintro.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
