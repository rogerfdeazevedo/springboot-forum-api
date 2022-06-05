package br.com.rogerfdeazevedo.springbootforumapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginTipControler {

    @RequestMapping("/")
    @ResponseBody
    public String sucesso(){
        return "Login realizado com sucesso!";
    }

}
