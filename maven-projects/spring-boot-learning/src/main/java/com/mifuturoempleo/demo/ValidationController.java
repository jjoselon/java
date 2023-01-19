package com.mifuturoempleo.demo;

import javax.validation.Valid;

import com.mifuturoempleo.Form.PersonForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ValidationController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("person/results");
	}

	@GetMapping("/person/new")
	public String showForm(PersonForm personForm, Model model) {
		model.addAttribute("title", "Register now!"); // Pass/Expose attrs to view template
		return "person/new"; // Name of the view
	}

	@PostMapping("/person/new")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult,
			RedirectAttributes rAttributes) {

		if (bindingResult.hasErrors()) {
			return "person/new";
		}
		rAttributes.addAttribute("name", personForm.getName());
		rAttributes.addAttribute("age", personForm.getAge());
		return "redirect:/person/showinfo";
	}

	@GetMapping(path = "person/showinfo")
	public String showInfo(@ModelAttribute(name = "name") String name, @ModelAttribute(name = "email") String email) {
		return "person/showinfo";
	}
}