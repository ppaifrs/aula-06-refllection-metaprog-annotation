package br.edu.ifrs.riogrande.entity;

// ORM: Object-Relational Mapping
// Mapamento Objeto-Relacional (SQL)
// O?M, ODM: Object-Document Mapping

public abstract class Usuario {

  private String email;
  private String senha;
  private Tema tema;

  public enum Tema {
    CLARO, ESCURO
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getSenha() {
    return senha;
  }
  
  public void setSenha(String senha) {
    this.senha = senha;
  }

  

}