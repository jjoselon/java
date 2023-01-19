package com.elempleo.trabajosihay.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImpl implements IVacantesService {

	private List<String> lista = null;
	
	public VacantesServiceImpl() {
		// init logic
		lista = new LinkedList<String>();
		lista.add("elemento #1 lista");
	}
	
	@Override
	public List<String> buscarTodas() {
		
		return lista;
	}

}
