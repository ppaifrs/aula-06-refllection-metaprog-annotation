package br.edu.ifrs.riogrande;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Campo {
    
    int comprimento();
    // int comprimento() default 50;
    // String nome();
}
