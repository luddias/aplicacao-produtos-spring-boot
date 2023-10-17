package br.ifes.dw.helloworld.controller;

import br.ifes.dw.helloworld.application.AppProdutoDB;
import br.ifes.dw.helloworld.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dbprodutos")

public class DBProdutoController {

  @Autowired
  private AppProdutoDB appProdutoDB;
  
  @GetMapping("/")
  public List<Produto>getAll(){
    try{
      return appProdutoDB.getAll();
    }catch(RuntimeException e){
      System.out.println(e.getMessage());
    }
      return null;
  }

  @PostMapping("/")
  public Produto createProduto (@RequestBody Produto produto) {
    try{
      appProdutoDB.getAll();
      return appProdutoDB.save(produto);
    }catch(RuntimeException e){
      System.out.println(e.getMessage());
    }
    return null;

  }

  @DeleteMapping("/{id}/deleteid")
  public Produto delete(@PathVariable int id){
    try{
      return appProdutoDB.delete((long) id);
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
        return null;
    }
  }

  @GetMapping("/{id}/getbyid")
  public Produto getById(@PathVariable int id) {
    try {
      return appProdutoDB.findById((long) id);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @PutMapping("/")
  public Produto update(@RequestBody Produto novoProd){
    try{
      return appProdutoDB.update(novoProd);
    }catch(RuntimeException e){
      System.out.println(e.getMessage());
      return null;
    }
  }
  
}