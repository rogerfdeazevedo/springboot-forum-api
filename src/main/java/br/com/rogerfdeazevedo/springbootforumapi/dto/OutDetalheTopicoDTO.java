package br.com.rogerfdeazevedo.springbootforumapi.dto;

import br.com.rogerfdeazevedo.springbootforumapi.domain.StatusTopico;
import br.com.rogerfdeazevedo.springbootforumapi.domain.Topico;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class OutDetalheTopicoDTO  {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<OutRespostaDTO> respostas;

    public OutDetalheTopicoDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.status =  topico.getStatus();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas().stream().map(OutRespostaDTO::new).collect(Collectors.toList()));
//        topico.getRespostas().forEach(resposta -> {
//            respostas.add(new OutRespostaDTO(resposta));
//        });
    }

}
