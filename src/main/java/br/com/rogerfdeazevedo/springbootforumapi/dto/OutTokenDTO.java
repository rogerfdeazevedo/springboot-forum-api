package br.com.rogerfdeazevedo.springbootforumapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OutTokenDTO {
    private String type;
    private String token;
}
