package br.ifes.dw.helloworld.exception;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(){
        super("Produto não encontrado");
    }
}
