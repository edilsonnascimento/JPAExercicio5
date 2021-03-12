package br.edu.curso.service;

import br.edu.curso.entity.Pessoa;
import br.edu.curso.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvar(Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> buscaPorId(Long id){
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public List<Pessoa> buscaPorNomeQBE(String nome){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Pessoa> example = Example.of(pessoa,matcher);

        return pessoaRepository.findAll(example);
    }

    public List<Pessoa> buscaTodosPorNome(){

        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        return pessoaRepository.findAll(sort);
    }

    @Transactional(readOnly = false)
    public void apagar(Pessoa pessoa){
        pessoaRepository.delete(pessoa);
    }
}
