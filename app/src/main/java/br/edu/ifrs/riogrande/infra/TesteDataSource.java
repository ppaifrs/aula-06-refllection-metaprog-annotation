package br.edu.ifrs.riogrande.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.edu.ifrs.riogrande.config.ConfigurationManager;

public class TesteDataSource extends DataSourceAdapter {

  private final ConfigurationManager configurationManager;

  private final String password;
  private final String username;
  private final String connectionString;

  public TesteDataSource(
    ConfigurationManager configurationManager) {

      this.configurationManager = configurationManager;

      this.username = this.configurationManager
        .get("database.connection.username")
        .orElseThrow();
      this.password = this.configurationManager
        .get("database.connection.password")
        .orElseThrow();
      this.connectionString = this.configurationManager
        .get("database.connection.string")
        .orElseThrow();

  }

  @Override
  public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(
      connectionString,
      username,
      password
    );
  }
}
