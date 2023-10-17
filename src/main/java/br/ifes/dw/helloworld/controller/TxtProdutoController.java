package br.ifes.dw.helloworld.controller;

import br.ifes.dw.helloworld.application.AppProdutoTxt;
import br.ifes.dw.helloworld.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/txtprodutos")

public class TxtProdutoController {

  @Autowired
  private AppProdutoTxt appProdutoTxt;
  
  @GetMapping("/")
  public List<Produto>getAll(){
    try{
      return appProdutoTxt.getAll();
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
      return null;
  }

  @PostMapping("/")
  public Produto createProduto (@RequestBody Produto produto) {
    try{
      appProdutoTxt.getAll();
      return appProdutoTxt.create(produto);
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
    return null;

  }

  @DeleteMapping("/{id}/deleteid")
  public Produto delete(@PathVariable int id){
    try{
      return appProdutoTxt.delete(id);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        return null;
    }
  }

  @GetMapping("/{id}/getbyid")
  public Produto getById(@PathVariable int id) {
    try {
      return appProdutoTxt.getById(id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @PutMapping("/")
  public Produto update(@RequestBody Produto novoProd){
    try{
      return appProdutoTxt.updateProduto(novoProd);
    }catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }
  
}