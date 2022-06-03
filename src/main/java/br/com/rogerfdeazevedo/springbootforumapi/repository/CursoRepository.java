package br.com.rogerfdeazevedo.springbootforumapi.repository;

import br.com.rogerfdeazevedo.springbootforumapi.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nomeCurso);

}
