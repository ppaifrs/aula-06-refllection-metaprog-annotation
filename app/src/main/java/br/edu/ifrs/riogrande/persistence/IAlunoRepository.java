package br.edu.ifrs.riogrande.persistence;

import java.util.Optional;

import br.edu.ifrs.riogrande.entity.Aluno;

// Java Persistence API

// A interface define um "contrato"
public interface IAlunoRepository {
  // CRUD
  void save(Aluno a); // pode não ser persistente (transiente)

  // design
  boolean delete(Aluno a); // nitpick (nitpicker)
  boolean deleteByMatricula(String matricula);

  void update(Aluno a);

  // em vez de null, Optional
  Optional<Aluno> findByMatricula(String matricula);

  Aluno loadByMatricula(String matricula) throws AlunoNotFoundException;

  class AlunoNotFoundException extends Exception { }

  class RepositoryException extends RuntimeException {
    // embrulhar (exception wrapper)
    public RepositoryException(Throwable e) {
      super(e);
    } 
  }

}