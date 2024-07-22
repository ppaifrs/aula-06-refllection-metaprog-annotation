package br.edu.ifrs.riogrande.entity;

import java.sql.Timestamp;

import br.edu.ifrs.riogrande.persistence.annotation.Coluna;
import br.edu.ifrs.riogrande.persistence.annotation.Tabela;

// Convenção sobre a Configuração
// Convention over Configuration (CoC)
// Evitar Configuração

// abstract class Entity {
//     abstract String getTableName();
// }
// classes/objetos sem extends, ou implements, com apenas atributos, get,set,
// POJO: Plain Old Java Object (POCO: Plain Old Csharp Object)

@Tabela(nome = "tbl_vcl")
public class Veiculo { // tabela tbl_vcl
    
    //@Campo(nome = "placa", anulavel = false, tamanho = 7, indexado = true)
    private String placa;
    // cmp_mdl
    @Coluna(nome = "cmp_mdl")
    private String modelo;
    private boolean eletrico;
    private String numeroChassi; // numero_chassi

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public boolean isEletrico() {
        return eletrico;
    }
    public void setEletrico(boolean eletrico) {
        this.eletrico = eletrico;
    }
    public String getNumeroChassi() {
        return numeroChassi;
    }
    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }
    
}
