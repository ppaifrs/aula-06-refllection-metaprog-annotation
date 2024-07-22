# Trabalho

```java
Passagem p1 = new Passagem(); // tabela passagem
p1.setOrigem("Porto Alegre"); // campo origem
p1.setDestino("São Paulo"); // campo destino
// outros campos

Repository<Passagem> repo = new Repository<>();
// se a tabela não existir, deve fazer o CREATE TABLE
repo.save(p1); // deve fazer o INSERT

Passagem p2 = repo.findById(1, Passagem.class);
System.out.println(p2.getId()); // 1
System.out.println(p2.getOrigem()); // Porto Alegre
System.out.println(p2.getDestino()); // São Paulo
```