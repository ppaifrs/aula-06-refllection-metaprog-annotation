package br.edu.ifrs.riogrande.persistence;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import javax.sql.DataSource;

import br.edu.ifrs.riogrande.persistence.IAlunoRepository.RepositoryException;

public class Repository<T, PK> {

  private final DataSource dataSource;

  public Repository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void save(T o) {
    // Produto => produto
    String tabela = o.getClass().getSimpleName().toLowerCase();
    // Campos
    List<Field> campos = Arrays.asList(o.getClass().getDeclaredFields());
    String campoSql = campos.stream() // API de Streams do Java
      .map(f -> f.getName().toLowerCase()) // cpf nome ...
      .collect(Collectors.joining(", "));
    
    String interrogacoes = campos.stream().map(f -> "?").collect(Collectors.joining(","));

    // try (Connection con = dataSource.getConnection()) {
    try (Connection con = null) {
      String sql = String.format(
        "INSERT INTO %s (%s) VALUES (%s)",
        tabela, campoSql, interrogacoes
      );
      System.out.println(sql);
      /*
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
      */
    } catch (SQLException e) {
      throw new RepositoryException(e);
    }
  }

  public T findByPrimaryKey(PK pk) {
    return null;
  }

}
