package br.edu.curso.service;

import br.edu.curso.entity.Endereco;
import br.edu.curso.entity.Pessoa;
import br.edu.curso.repository.EnderecoRepository;
import br.edu.curso.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = false)
    public void salvar(Endereco endereco, Pessoa pessoa){
        enderecoRepository.save(endereco);
        pessoaRepository.save(pessoa);
    }
}
