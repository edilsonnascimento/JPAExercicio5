package br.edu.curso.entity.projection;

import org.springframework.beans.factory.annotation.Value;

public interface NomeCidade {

    @Value("#{(target.enderecos.cidade)}")
    String getCidade();
}
