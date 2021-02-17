package br.edu.curso.entity.projection;

import org.springframework.beans.factory.annotation.Value;

public interface NomeTelefone {

    @Value("#{target.nome} #{target.telefone}")
    String  getNomeTelefone();
}
