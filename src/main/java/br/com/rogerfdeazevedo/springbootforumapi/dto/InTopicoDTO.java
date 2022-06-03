package br.com.rogerfdeazevedo.springbootforumapi.dto;

import br.com.rogerfdeazevedo.springbootforumapi.domain.Curso;
import br.com.rogerfdeazevedo.springbootforumapi.domain.Topico;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@EqualsAndHashCode
public class InTopicoDTO {

    @NotNull @NotEmpty @Length(max = 50)
    private String titulo;
    @NotNull @NotEmpty @Length(max = 50)
    private String mensagem;
    @NotNull @NotEmpty @Length(max = 50)
    private String nomeCurso;

    public Topico converterParaTopico(Curso curso) {
        return new Topico(this.titulo, this.mensagem, curso);
    }
}
