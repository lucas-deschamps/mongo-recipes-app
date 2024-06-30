package com.sanvicente.mongo.recipes.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("/saludar")
    public Integer helloWorld(){
        return 111;
    }

}
