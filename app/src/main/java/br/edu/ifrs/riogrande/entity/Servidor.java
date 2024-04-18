package br.edu.ifrs.riogrande.entity;

public /* concrete */ class Servidor extends Usuario {

  public enum Perfil {
    SECRETARIA, COORDENACAO
  }

  private int siape;
  private Perfil perfil;

  public int getSiape() {
    return siape;
  }

  public void setSiape(int siape) {
    this.siape = siape;
  }

  public Perfil getPerfil() {
    return perfil;
  }

  public void setPerfil(Perfil perfil) {
    this.perfil = perfil;
  }

}
