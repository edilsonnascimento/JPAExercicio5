package br.edu.curso.repository;

import br.edu.curso.entity.Pessoa;
import br.edu.curso.entity.projection.Homonimos;
import br.edu.curso.entity.projection.NomeCidade;
import br.edu.curso.entity.projection.NomeTelefone;
import br.edu.curso.entity.projection.SemEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

        Pessoa findByNomeAndIdade(String nome, Integer idade);

        List<Pessoa> findByEnderecosCidade(String cidade);

        List<Pessoa> findFirst3yOrderByIdadeAsc();

        List<Pessoa> findTop3ByIdade();

        @Query("SELECT p FROM Pessoa p WHERE p.idade > 65 ORDER BY p.nome ASC")
        List<Pessoa> findByPessoasIdosas();

        @Query(value = "SELECT * FROM pessoa WHERE data_nascimento = ?1", nativeQuery = true)
        List<Pessoa> findByAniversariantesHoje(LocalDate data);

        @Query(name= "Pessoa.byIdade")
        List<Pessoa> findByIdade(Integer idade);

        @Query(name = "Pessoa.byNome")
        List<Pessoa> findByNome(String nome);

        SemEndereco findPessoaById(Long id);

        NomeCidade findPessoaCidadeByNome(String nome);

        NomeTelefone findPessoaNomeTelefoneByNome(String nome);

        @Query("SELECT p.nome AS nome, COUNT(p.id) AS total " +
                "FROM Pessoa p " +
                "GROUP BY p.nome")
        List<Homonimos> findByHomonimos();
}
