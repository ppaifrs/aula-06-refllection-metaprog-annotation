package br.edu.ifrs.riogrande;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

import javax.sql.DataSource;

import br.edu.ifrs.riogrande.config.ConfigurationManager;
import br.edu.ifrs.riogrande.entity.Aluno;
import br.edu.ifrs.riogrande.entity.Servidor;
import br.edu.ifrs.riogrande.infra.TesteDataSource;
import br.edu.ifrs.riogrande.persistence.IAlunoRepository;
import br.edu.ifrs.riogrande.persistence.SqlAlunoRepository;

public class App {
    public static void main(String[] args) {
        System.out.println("Estou vivo!");
        // Metaprogramação
        // Programa para criar Programa
        // Java Reflection (reflexão)
        Class<Aluno> classeAluno = Aluno.class;
        Aluno a = new Aluno();
    
        // Method m = a.getClass().getDeclaredMethods()[0];
        // m.invoke(a);

        refletir(a);
        refletir(new Servidor());

        String ddl = ddl(a); // CREATE TABLE ...
        System.out.println(ddl);
    }

    static String ddl(Object o) {
        Map<String, String> mapaCampos =
            Map.of("String",        "VARCHAR",
                   "LocalDate",     "DATE",
                   "LocalDateTime", "TIMESTAMP");

        StringBuilder campos = new StringBuilder();
        for (Field f : o.getClass().getDeclaredFields()) {
            campos
               .append("    ")
               .append(mapaCampos.get(f.getType().getSimpleName()))
                    .append(f.isAnnotationPresent(Comprimento.class) ? 
                    "(" + f.getAnnotation(Comprimento.class).value() + ")" : "")
               .append(f.isAnnotationPresent(Campo.class) ?
                  "(" + f.getAnnotation(Campo.class).comprimento() + ")" :
                  "")
               .append(" ")
               .append(f.getName())
               .append(",\n");
        }
        // FIXME: faça melhor pelo amor ...
        campos.delete(campos.length()-2, campos.length()-1);

        StringBuilder ddl = new StringBuilder();
        String nomeTabela = o.getClass().getSimpleName().toLowerCase() + "s";
        return ddl.append("CREATE TABLE ")
          .append(nomeTabela)
          .append(" (\n")
          .append(campos.toString())
          .append(")").toString(); // CREATE TABLE ...
    }

    static void refletir(Object o) {
        System.out.println(o.getClass().getSuperclass().getSuperclass().getSuperclass());
        System.out.println(o.getClass().getSuperclass().getSuperclass());
        System.out.println(o.getClass().getSuperclass());
        System.out.println(o.getClass());
        System.out.println(o.getClass().getName()); // qualified name
        System.out.println(o.getClass().getSimpleName());
        // fiels públicos
        System.out.println(Arrays.toString(o.getClass().getFields()));
        System.out.println(Arrays.toString(
            o.getClass().getDeclaredFields()));
    }

    
}
