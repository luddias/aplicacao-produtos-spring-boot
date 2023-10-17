package br.ifes.dw.helloworld.controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/hello")

public class HelloWorldController {

  @GetMapping("/")
  public String helloWorld(){
    return "Agora vai? foi";
  }

  @GetMapping("/xyz")
  public String helloWorld2(@RequestParam String nome){
    return "Preneme netre: " + nome;
  }

  
}