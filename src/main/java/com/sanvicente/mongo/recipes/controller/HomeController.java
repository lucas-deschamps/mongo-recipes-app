package com.sanvicente.mongo.recipes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("/saludar")
    public String helloWorld(){
        return "Hola Mundo! :D";
    }

    @GetMapping("/petro")
    public String helloPetro(){
        return "Hola Petro! :D";
    }
}
