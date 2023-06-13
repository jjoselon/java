package com.inventario.appinventario.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InventoryController {

    @GetMapping("/")
    public String list() {
        return "index";
    }

}
