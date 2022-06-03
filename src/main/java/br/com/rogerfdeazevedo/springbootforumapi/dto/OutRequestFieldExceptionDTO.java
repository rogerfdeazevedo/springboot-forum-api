package br.com.rogerfdeazevedo.springbootforumapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutRequestFieldExceptionDTO {
    private String field;
    private String message;
}
