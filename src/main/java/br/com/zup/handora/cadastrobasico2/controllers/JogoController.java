package br.com.zup.handora.cadastrobasico2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(JogoController.BASE_URI)
public class JogoController {

    public final static String BASE_URI = "/jogos";

}
