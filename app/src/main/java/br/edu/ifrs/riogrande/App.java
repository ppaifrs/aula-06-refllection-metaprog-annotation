package br.edu.ifrs.riogrande;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.sql.DataSource;

import br.edu.ifrs.riogrande.config.ConfigurationManager;
import br.edu.ifrs.riogrande.entity.Aluno;
import br.edu.ifrs.riogrande.entity.Produto;
import br.edu.ifrs.riogrande.entity.Proprietario;
import br.edu.ifrs.riogrande.entity.Veiculo;
import br.edu.ifrs.riogrande.infra.DataSourceAdapter;
import br.edu.ifrs.riogrande.infra.TesteDataSource;
import br.edu.ifrs.riogrande.persistence.Repository;
import br.edu.ifrs.riogrande.persistence.annotation.Coluna;
import br.edu.ifrs.riogrande.persistence.annotation.Tabela;
import br.edu.ifrs.riogrande.util.StringUtil;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Estou vivo!");
    
    Aluno a = new Aluno();
    Produto p = new Produto();

    ConfigurationManager cm = new ConfigurationManager();
    DataSource ds = new TesteDataSource(cm);

    Repository<Aluno, Integer> repoAluno = new Repository(ds);
    repoAluno.save(a);

    Repository<Produto, Integer> repoProduto = new Repository<>(ds);

    repoProduto.save(p);

    // refletir(a);
    // refletir(s);

    Veiculo v5 = new Veiculo();
    v5.setModelo("Punto");
    v5.setEletrico(false);
    v5.setNumeroChassi("1334AFDD4555");
    v5.setPlaca("IFS4522");
    // INSERT INTO veiculo (placa, modelo, eletrico) VALUES (?, ?, ?)
    Proprietario p5 = new Proprietario();
    // v5.getPlaca(), 
    System.out.println(Arrays.toString(Veiculo.class.getDeclaredFields()));
    System.out.println(Arrays.toString(v5.getClass().getDeclaredFields()));
    System.out.println(v5.getClass().getDeclaredFields()[2].getType());
    System.out.println(v5.getClass().getSimpleName().toLowerCase()); // veiculo

    Stream.of(v5.getClass().getMethods())
      .filter(m -> m.getName().startsWith("get"))
      .forEach(System.out::println);

    Method getModelo = v5.getClass().getMethods()[4];
    System.out.println(getModelo);
    System.out.println(getModelo.invoke(v5));
    
    Stream.of(v5.getClass().getDeclaredFields()).forEach(f -> {
      try {
        f.setAccessible(true);
        System.out.println(f.get(v5)); // pegar o valor do campo
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    
    if (v5.getClass().isAnnotationPresent(Tabela.class)) {
      System.out.println(v5.getClass().getAnnotation(Tabela.class).nome());
    } else {
      System.out.println(v5.getClass().getSimpleName().toLowerCase());
    }


      // Stream.of(v5.getClass().getDeclaredFields())
      //   .map(Field::getName)
      //   .map(String::toLowerCase)
      //   .map(StringUtil::splitCase)
      //   .map(list -> StringUtil.join(list, "_"))
      //   .forEach(System.out::println);


    Stream.of(v5.getClass().getDeclaredFields()).forEach(f -> {
      if (f.isAnnotationPresent(Coluna.class)) {
        System.out.println(f.getAnnotation(Coluna.class).nome());
      } else {
        System.out.println(f.getName().toLowerCase());
      }
    });


    // Reflection => Metaprogramação
    // Estendido: annotations (anotações de código)
    // Em runtime (em execução)
    // Em compile time (interceptar e alterar o código-fonte)
    // Alterar o bytecode

    // INSERT INTO proprietario (cnh, nome, categoria) VALUES (?, ?, ?)
    // ? => p5.getCnh(); ? => p5.getNome()

    
  }

  // REFLEXÃO (Reflection)
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
