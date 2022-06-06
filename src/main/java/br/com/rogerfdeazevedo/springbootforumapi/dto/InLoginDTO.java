package br.com.rogerfdeazevedo.springbootforumapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InLoginDTO {
    private String email;
    private String senha;
}
