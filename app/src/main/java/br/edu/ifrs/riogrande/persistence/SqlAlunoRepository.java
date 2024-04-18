package br.edu.ifrs.riogrande.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.Optional;

import javax.sql.DataSource;

import br.edu.ifrs.riogrande.entity.Aluno;
import br.edu.ifrs.riogrande.infra.TesteDataSource;


// Dependency Injection (Injeção de Dependências)
public class SqlAlunoRepository implements IAlunoRepository {

  // dependência, data source agnostic (ignorant)
  private final DataSource dataSource;

  public SqlAlunoRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void save(Aluno a) { // DataSource (abstrair)
    try (Connection con = dataSource.getConnection()) {
      String sql = """
        INSERT INTO alunos (
          matricula, data_ingresso, email, senha
        )
        VALUES (?, ?, ?, ?)
      """;
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setString(1, a.getMatricula());
      stmt.setDate(2, java.sql.Date.valueOf(a.getDataIngresso()));
      stmt.setString(3, a.getEmail());
      if (a.getSenha() == null) {
        stmt.setNull(4, Types.VARCHAR);
      } else {
        stmt.setString(4, a.getSenha());
      }
      stmt.executeUpdate();

    } catch (SQLException e) {
      throw new RepositoryException(e);
    }
    // conectar ao banco de dados
    // submeter o comando
    // testar resposta
    // desconectar do banco de dados
  }

  @Override
  public boolean delete(Aluno a) {
    try {
      Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mochinho", "usuario", "senha"); // hard-coded

      con.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public boolean deleteByMatricula(String matricula) {
    throw new UnsupportedOperationException("Unimplemented method 'deleteByMatricula'");
  }

  @Override
  public void update(Aluno a) {
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public Optional<Aluno> findByMatricula(String matricula) {
    throw new UnsupportedOperationException("Unimplemented method 'findByMatricula'");
  }

  @Override
  public Aluno loadByMatricula(String matricula) throws AlunoNotFoundException {
    throw new UnsupportedOperationException("Unimplemented method 'loadByMatricula'");
  }
  
}
