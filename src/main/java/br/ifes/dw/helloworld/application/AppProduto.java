package br.ifes.dw.helloworld.application;
import java.util.ArrayList;
import java.util.List;
import br.ifes.dw.helloworld.model.Produto;
import org.springframework.stereotype.Component;
import br.ifes.dw.helloworld.exception.ProdutoNotFoundException;

@Component
public class AppProduto {
  private List<Produto> produtos = new ArrayList<Produto>();
  private int lastId = 0;
  
  public List<Produto> getAll() {
  return produtos;
  }
  
  public Produto create(Produto produto) {
  lastId++;
  produto.setId(lastId);
  produtos.add(produto);
  return produto;
  }
  
  public Produto delete(int id) throws Exception{
    for(Produto item:this.produtos){
      if(item.getId() == id) {
        this.produtos.remove(item);
        return item;
      }}
    throw new ProdutoNotFoundException();
  }

  public Produto getById(int id) throws Exception{

    if(id==0){
      throw new ProdutoNotFoundException();
    }
    
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
      return old_produto;
    }catch (Exception e){
      throw new ProdutoNotFoundException();
    }
  }

}

// DTO uma classe a nivel de controler para obter dados de entrada do usuário...
// Sonarcloud - verificar qualidade do código
