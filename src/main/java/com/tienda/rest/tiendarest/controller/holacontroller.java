package com.tienda.rest.tiendarest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class holacontroller {

    @GetMapping
    public String hola(){
        return "Hola mundo";
    }
}
