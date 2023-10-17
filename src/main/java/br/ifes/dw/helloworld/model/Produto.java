package br.ifes.dw.helloworld.model;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String nome;

  private double preco;

}