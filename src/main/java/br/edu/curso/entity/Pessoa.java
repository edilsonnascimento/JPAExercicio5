package br.edu.curso.entity;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NamedQuery(
        name = "Pessoa.byIdade",
        query = "SELECT p FROM Pessoa p WHERE p.idade = ?1")
@NamedNativeQuery(
        name = "Pessoa.byNome",
        query = "SELECT * FROM pessoa WHERE nome like ?1",
        resultClass = Pessoa.class)
@NamedStoredProcedureQuery(
        name = "Pessoa.totalCadastrado",
        procedureName = "procedure_conta_pessoa",
        parameters = {
                @StoredProcedureParameter(
                        mode = ParameterMode.IN,
                        name = "argumento",
                        type = Integer.class),
                @StoredProcedureParameter(
                        mode = ParameterMode.OUT,
                        name = "resulado",
                        type = Integer.class)
        })
public class Pessoa extends AbstractPersistable<Long> {

    private String nome;
    @OneToMany(mappedBy = "endereco")
    private Set<Endereco> enderecos;
    private String telefone;
    private int idade;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
