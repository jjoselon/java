package com.company.webflux.services;

import com.company.webflux.models.Heroe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyService implements IServiceImpl {

    @Autowired
    private Heroe heroe;

    /*
    public MyService(Heroe heroe) {
        this.heroe = heroe;
    }
    */


    public String sayHello() {
        return "Hello " + heroe.getName() + " !";
    }
}
