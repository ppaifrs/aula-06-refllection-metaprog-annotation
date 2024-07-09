package br.edu.ifrs.riogrande;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.sql.DataSource;

import br.edu.ifrs.riogrande.config.ConfigurationManager;
import br.edu.ifrs.riogrande.entity.Aluno;
import br.edu.ifrs.riogrande.entity.Produto;
import br.edu.ifrs.riogrande.infra.DataSourceAdapter;
import br.edu.ifrs.riogrande.infra.TesteDataSource;
import br.edu.ifrs.riogrande.persistence.Repository;

public class App {
  public static void main(String[] args) {
    System.out.println("Estou vivo!");
    
    Aluno a = new Aluno();
    Produto p = new Produto();

    ConfigurationManager cm = new ConfigurationManager();
    DataSource ds = new TesteDataSource(cm);

    Repository<Aluno, Integer> repoAluno = new Repository(ds);
    repoAluno.save(a);

    Repository<Produto, Integer> repoProduto = new Repository<>(ds);

    repoProduto.save(p);

    refletir(a);
    // refletir(s);
    
  }

  static void refletir(Object o) {
    Class clazz = o.getClass();
    System.out.println(clazz.getName()); // nome qualificado
    System.out.println(clazz.getSimpleName()); // nome da classe

    Field[] fields = clazz.getDeclaredFields();
    for (var f : fields) {
      System.out.println(f.getName());
      System.out.println(f.getType());
    }

    try {
      Method metodo = clazz.getMethod("getMatricula");
      Object resultado = metodo.invoke(o);
      System.out.println(resultado);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
