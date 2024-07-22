package br.edu.ifrs.riogrande.entity;

public class Produto {
    
    // @Coluna("id") // configuração
    private int codigo; // convenção

    private String descricao;
    private String fabricante;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    
}
