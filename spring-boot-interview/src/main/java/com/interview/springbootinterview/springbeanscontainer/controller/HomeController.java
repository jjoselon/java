package com.interview.springbootinterview.springbeanscontainer.controller;

import com.interview.springbootinterview.springbeanscontainer.beans.IVehiculo;
import com.interview.springbootinterview.springbeanscontainer.beans.RepositoryDTO;
import com.interview.springbootinterview.springbeanscontainer.beans.Transporte;
import com.interview.springbootinterview.springbeanscontainer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//    @Qualifier("transporte")
    @Autowired
    private IVehiculo vehiculo;

    @Autowired
    private RepositoryDTO repo;

    @Autowired
    private User userBean;

    private User userBeanNo;
    @Autowired
    private Transporte transporte;

//    @Autowired
//    public HomeController(User userBeanNo) {
//        this.userBeanNo = userBeanNo;
//    }

    @GetMapping(path = "/home")
    public String home() {
        return repo.create();
    }

    @GetMapping(path = "/home2")
    public String home2() {
        return userBean.getName();
    }

    @GetMapping(path = "/home3")
    public String home3() {
        return userBeanNo.getName();
    }

    @GetMapping(path = "/inyection-by-constructor")
    public String byConstructor() {
        return repo.create();
    }

    @GetMapping(path = "/qualifier")
    public String qualifier() {
        if (vehiculo.getMarca() == "BMW") {
            return "ricachon";
        }
        return "pobre";
    }
}
