package br.edu.curso.repository;

import br.edu.curso.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Procedure(procedureName = "procedures_endereco_completo")
    String procedureEnderecoCompleto(Integer argumento);

    @Procedure()
    String procedures_endereco_completoo(Integer argumento);

    @Query("SELECT e FROM Endereco e " +
            "WHERE e.cep >= :cep")
    List<Endereco> findByIdadeOuNome(@Param("cep") String cep);

    @Modifying
    @Query("update Endereco e set e.cidade = ?1 where e.id = ?2")
    int updateCidadeByld(String cidade, Long id);

    @Modifying
    @Query("delete from Endereco e where e.id =  :id")
    int deleteEndereco(@Param("id") Long id);

}
