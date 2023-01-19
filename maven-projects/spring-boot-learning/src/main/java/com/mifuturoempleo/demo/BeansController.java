package com.mifuturoempleo.demo;

import com.mifuturoempleo.beans.BeanOne;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // This means that this class is a Controller
@RequestMapping(path="/spring-framework/ioc") // This means URL's start with /demo (after Application path)
public class BeansController {

    ApplicationContext context;

    @GetMapping("/bean")
	public String showForm(Model model) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(WebSecurityConfig.class);
        
        BeanOne beanInstOne = ctx.getBean(BeanOne.class);
        //model.addAttribute("toString", "hola");
        model.addAttribute("toString", beanInstOne.toString());
        
		return "spring-framework/beans/declaration"; // Name of the view
	}
}
