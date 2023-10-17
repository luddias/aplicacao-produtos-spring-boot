package br.ifes.dw.helloworld.repository;
import br.ifes.dw.helloworld.model.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface TxtGenericRepository<T>{
    public List<T> readFile() throws IOException;
    public void createFile() throws IOException;
    public void updateFile(List<T> t) throws IOException;
    public void addNewData(Produto prod) throws IOException;
}