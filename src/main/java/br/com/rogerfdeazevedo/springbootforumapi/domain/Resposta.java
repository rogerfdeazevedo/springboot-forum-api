package br.com.rogerfdeazevedo.springbootforumapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Resposta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;
	@ManyToOne
	private Topico topico;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne
	private Usuario autor;
	private Boolean solucao = false;
}
