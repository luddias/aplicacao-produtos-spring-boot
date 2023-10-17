package br.ifes.dw.helloworld.application;

import br.ifes.dw.helloworld.model.Produto;
import br.ifes.dw.helloworld.repository.DBRepository;
import br.ifes.dw.helloworld.exception.ProdutoNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class AppProdutoDB {
  private final DBRepository dbrepo;


  public AppProdutoDB(DBRepository produtoRepo) {
    this.dbrepo = produtoRepo;
  }

  public List<Produto> getAll() {
    return dbrepo.findAll();
  }

  public Produto findById(Long id) {
    return dbrepo.findById(id).orElseThrow(ProdutoNotFoundException::new);
  }

  public Produto save(Produto produto) {
    dbrepo.save(produto);
    return produto;
  }

  public Produto delete(Long id){
    Produto produto = findById(id);
    dbrepo.deleteById(id);
    return produto;
  }

  public Produto update(Produto novoProduto) {
    Produto produtoExistente = dbrepo.findById((long) novoProduto.getId()).orElseThrow(ProdutoNotFoundException::new);

    if (produtoExistente != null) {
      produtoExistente.setNome(novoProduto.getNome());
      produtoExistente.setPreco(novoProduto.getPreco());
      dbrepo.save(produtoExistente);
      return produtoExistente;
    }
    throw new ProdutoNotFoundException();
  }
}