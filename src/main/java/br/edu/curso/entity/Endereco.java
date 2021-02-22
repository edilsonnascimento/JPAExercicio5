package br.edu.curso.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
        name = "Endereco.completo",
        procedureName = "procedure_endereco_completo",
        parameters = {
                @StoredProcedureParameter(
                        mode = ParameterMode.IN,
                        name = "argumento",
                        type = Integer.class),
                @StoredProcedureParameter(
                        mode = ParameterMode.OUT,
                        name = "resulado",
                        type = String.class)
        })
public class Endereco extends AbstractPersistable<Long> {

    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
