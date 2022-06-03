package br.com.rogerfdeazevedo.springbootforumapi.dto;

import br.com.rogerfdeazevedo.springbootforumapi.domain.Topico;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class OutTopicoDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private String nomeCurso;
    private LocalDateTime dataCriacao;

    public OutTopicoDTO(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.nomeCurso = topico.getCurso().getNome();
        this.dataCriacao = topico.getDataCriacao();
    }

}
