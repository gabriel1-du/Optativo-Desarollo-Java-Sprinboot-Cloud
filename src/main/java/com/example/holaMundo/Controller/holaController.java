package com.example.holaMundo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class holaController {


    @GetMapping("saludoGet")
    public String HolaMundo(){
        return "¡Hola, Mundo Post!";
    }


    @PostMapping
    public String HolaMundoPost(){
        return "¡Hola, Mundo! (POST)";
    }

}
