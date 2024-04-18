package br.edu.ifrs.riogrande;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Comprimento {
    // @Comprimento(50)
    int value(); // @Comprimento(50)
}
