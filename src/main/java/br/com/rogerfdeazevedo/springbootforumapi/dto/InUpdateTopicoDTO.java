package br.com.rogerfdeazevedo.springbootforumapi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@EqualsAndHashCode
public class InUpdateTopicoDTO {
    @NotNull  @NotEmpty  @Length(max = 50)
    private String titulo;
    @NotNull @NotEmpty @Length(max = 50)
    private String mensagem;
}
