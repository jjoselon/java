package com.inventario.appinventario.controller;

import com.inventario.appinventario.entity.Product;
import com.inventario.appinventario.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ui/forms/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/home")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = service.get(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
