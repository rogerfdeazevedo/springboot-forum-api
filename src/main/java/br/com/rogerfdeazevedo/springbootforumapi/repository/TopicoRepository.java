package br.com.rogerfdeazevedo.springbootforumapi.repository;

import br.com.rogerfdeazevedo.springbootforumapi.domain.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByCurso_Nome(String nomeCurso, Pageable pageable);

    @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    List<Topico> buscarPorNomeCurso(@Param("nomeCurso") String nomeCurso);

}
