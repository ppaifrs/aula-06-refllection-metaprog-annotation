package br.edu.ifrs.riogrande.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// final: ninguém pode estender
public final class StringUtil { 
    // construtor private: ninguém pode instanciar
    private StringUtil() {
        /* não instanciar */
    }
    
    public static void main(String[] args) {
        //System.out.println(splitCase("splitCaseMaisIndices"));

        System.out.println(join(List.of("a", "b", "c"), "888888"));
    }

    public static List<String> splitCase(String str) {
        // 012345678
        // splitCaseMaisIndices
        List<String> split = new ArrayList<>();
        int ultimoIndice = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                split.add(str.substring(ultimoIndice, i));
                ultimoIndice = i;
            }
        }
        split.add(str.substring(ultimoIndice, str.length()));
        return split;
    }


    public static String join(Iterable<String> strings, String separador) {
        StringBuilder sb = new StringBuilder();
        for (var s : strings) {
            sb.append(s).append(separador);
        }
        return sb.toString().substring(0, sb.length() - separador.length());
    }
}
