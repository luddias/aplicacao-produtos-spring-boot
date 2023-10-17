package br.ifes.dw.helloworld.application;

import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.TxtRepository;
import org.springframework.stereotype.Component;
import br.ifes.dw.helloworld.exception.ProdutoNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppProdutoTxt{
  private List<Produto> produtos;
  private TxtRepository txtrepo;
  private int lastId = 0;

  public AppProdutoTxt(){
    try{
      txtrepo = new TxtRepository("produtos.txt");
    }catch(IOException e) {
      System.out.println(e.getMessage());
    }

  }
  public List<Produto> getAll() throws IOException{
    this.produtos=txtrepo.readFile();
    if(!this.produtos.isEmpty()) {
      lastId = this.produtos.get(this.produtos.size() - 1).getId();
    }
    return this.produtos;
  }
  
  public Produto create(Produto produto) throws IOException {
  lastId++;
  produto.setId(lastId);
  produtos.add(produto);
  txtrepo.addNewData(produto);
  return produto;
  }
  
  public Produto delete(int id) throws Exception{
    for(Produto item:this.produtos){
      if(item.getId() == id) {
        this.produtos.remove(item);
        txtrepo.updateFile(this.produtos);
        return item;
      }}
    throw new ProdutoNotFoundException();
  }

  public Produto getById(int id) throws Exception{

    if(id==0){
      throw new ProdutoNotFoundException();
    }
    this.produtos = txtrepo.readFile();
    for(Produto item : this.produtos){
      if(item.getId() == id) {
        System.out.println(id);
        return item;
      }
    }
    throw new ProdutoNotFoundException();
  }

  public Produto updateProduto(Produto new_produto) throws Exception{

    int id = new_produto.getId();

    try{
      Produto old_produto = getById(id);
      old_produto.setNome(new_produto.getNome());
      old_produto.setPreco(new_produto.getPreco());
      txtrepo.updateFile(this.produtos);
      return old_produto;
    }catch (Exception e){
      throw new ProdutoNotFoundException();
    }
  }

}
