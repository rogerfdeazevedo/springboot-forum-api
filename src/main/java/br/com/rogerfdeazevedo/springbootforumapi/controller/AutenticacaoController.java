package br.com.rogerfdeazevedo.springbootforumapi.controller;

import br.com.rogerfdeazevedo.springbootforumapi.config.security.TokenService;
import br.com.rogerfdeazevedo.springbootforumapi.dto.InLoginDTO;
import br.com.rogerfdeazevedo.springbootforumapi.dto.OutTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<OutTokenDTO> autenticar(@RequestBody @Valid InLoginDTO inLoginDTO){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(inLoginDTO.getEmail(), inLoginDTO.getSenha());
        try {
            Authentication authentication = authenticationManager.authenticate(login);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new OutTokenDTO("Bearer", token));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
