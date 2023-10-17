package br.ifes.dw.helloworld.controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.application.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

  @Autowired
  private AppProduto appProduto;
  
  @GetMapping("/")
  public List<Produto>getAll(){
    return appProduto.getAll();
  }

  @PostMapping("/")
  public Produto createProduto (@RequestBody Produto produto) {return appProduto.create(produto); }

  @DeleteMapping("/{id}/deleteid")
  public Produto delete(@PathVariable int id){
    try{
      return appProduto.delete(id);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return null;
    }
  }

  @GetMapping("/{id}/getbyid")
  public Produto getById(@PathVariable int id) {
    try {
      return appProduto.getById(id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @PutMapping("/")
  public Produto update(@RequestBody Produto novoProd){
    try{
      return appProduto.updateProduto(novoProd);
    }catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }
  
}