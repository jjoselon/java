package com.elempleo.trabajosihay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elempleo.trabajosihay.service.IVacantesService;

@RequestMapping("/home")
@Controller
public class HomeController {

	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<String> lista = serviceVacantes.buscarTodas();
		
		model.addAttribute("extension", "jpg");
		model.addAttribute("item0", lista.get(0));
		return "home/index";
	}
}
