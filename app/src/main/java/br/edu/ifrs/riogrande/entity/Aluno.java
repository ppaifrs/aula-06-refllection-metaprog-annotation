package br.edu.ifrs.riogrande.entity;

import java.time.LocalDate;

import br.edu.ifrs.riogrande.Campo;
import br.edu.ifrs.riogrande.Comprimento;


// @Tabela(nome="tbl_alunos")
public class Aluno extends Usuario {

  @Comprimento(11)
  private String cpf; // metadado

  @Campo(comprimento = 100)
  // @Comprimento(50)
  private String matricula; // VARCHAR(500)
  // private String nomePai;
  private LocalDate dataIngresso;

  public String getMatricula() {
    return matricula;
  }
  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }
  public LocalDate getDataIngresso() {
    return dataIngresso;
  }
  public void setDataIngresso(LocalDate dataIngresso) {
    this.dataIngresso = dataIngresso;
  }
  
  @Override // annotation = anotação
  public String toString() {
      // TODO Auto-generated method stub
      return super.toString();
  }

}
