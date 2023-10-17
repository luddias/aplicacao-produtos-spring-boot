package br.ifes.dw.helloworld.repository;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import br.ifes.dw.helloworld.model.Produto;

public class TxtRepository implements TxtGenericRepository<Produto> {
    private final String nomeArquivo;
    public TxtRepository(String nomeArquivo) throws IOException {
        this.nomeArquivo = nomeArquivo;
        createFile();
    }

    @Override
    public List<Produto> readFile() throws IOException{
        FileReader fileReader = new FileReader(nomeArquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linha = "";
        List<Produto> produtos = new ArrayList<Produto>();


        List<String> result = new ArrayList<String>();

        while ((linha = bufferedReader.readLine()) != null) {
            System.out.println(linha);
            if (linha != null && !linha.isEmpty()) {
                result.add(linha);
            }
        }
        fileReader.close();
        bufferedReader.close();

        for (String s : result) {

            String[] prod = s.split(";");


            Produto p = new Produto();
            p.setId(Integer.valueOf(prod[0]));
            p.setNome(prod[1]);
            prod[2] = prod[2].replaceAll( "," , "." );
            p.setPreco(Double.parseDouble(prod[2]));

            produtos.add(p);
        }

        return produtos;
    }
    @Override
    public void createFile() throws IOException{
        java.io.File arquivo = new java.io.File(nomeArquivo);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }
    @Override
    public void updateFile(List<Produto> produtos) throws IOException{
        FileWriter fileWriter = new FileWriter(nomeArquivo, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(Produto prod:produtos) {
            printWriter.println(String.format("%d;%s;%f", prod.getId(), prod.getNome(), prod.getPreco()));
        }
        printWriter.flush();
        printWriter.close();
    }

    @Override
    public void addNewData(Produto prod) throws IOException{
        FileWriter fileWriter = new FileWriter(nomeArquivo, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(String.format("%d;%s;%.2f", prod.getId(), prod.getNome(), prod.getPreco()));
        printWriter.flush();
        printWriter.close();
    }


}
