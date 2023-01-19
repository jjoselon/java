package com.elempleo.trabajosihay.repository;

import org.springframework.data.repository.CrudRepository;

import com.elempleo.trabajosihay.model.Vacante;

public interface VacanteRepository extends CrudRepository<Vacante, Integer> {
	// Vacante seria el modelo que va a mapear este repositorio
	// Integer seria el tipo de dato de la llave primaria de nuestro modelo
	// see https://www.udemy.com/course/spring-framework-desarrollo-web-spring-mvc/learn/lecture/17362956?start=0#content
	// Estos métodos en tiempo de ejecución seran ejecutados/implementados por Spring.
}
