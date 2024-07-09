package br.edu.ifrs.riogrande.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import br.edu.ifrs.riogrande.entity.Aluno;
import br.edu.ifrs.riogrande.persistence.IAlunoRepository.RepositoryException;

public abstract class BaseRepository<T> {

    private DataSource dataSource;

    protected abstract String tabela(); // return "alunos";
    protected abstract List<String> colunas();
    protected abstract void populateStatement(PreparedStatement stmt, T obj) throws SQLException;

    void save(T a) { // ? TEMPLATE METHOD
        try (Connection con = dataSource.getConnection()) {
            String sql = """
                INSERT INTO %tabela% (
                    %colunas%
                )
                VALUES (%colunas.repeat('?'))
            """.replace("%tabela%", tabela());

            PreparedStatement stmt = con.prepareStatement(sql);
            populateStatement(stmt, a);
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    } 

} 

class Aluno2Repository extends BaseRepository<Aluno> {

    @Override
    protected String tabela() {
        return "alunos";
    }

    @Override
    protected List<String> colunas() {
        return List.of("matricula", "data_ingresso", "email", "senha");
    }

    @Override
    protected void populateStatement(PreparedStatement stmt, Aluno obj) throws SQLException {
        stmt.setString(1, obj.getMatricula());
    }

}