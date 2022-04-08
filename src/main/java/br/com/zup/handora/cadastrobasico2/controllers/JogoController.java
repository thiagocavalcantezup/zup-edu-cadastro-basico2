package br.com.zup.handora.cadastrobasico2.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.cadastrobasico2.models.Jogo;
import br.com.zup.handora.cadastrobasico2.models.JogoDTO;
import br.com.zup.handora.cadastrobasico2.repositories.JogoRepository;

@RestController
@RequestMapping(JogoController.BASE_URI)
public class JogoController {

    public final static String BASE_URI = "/jogos";

    private final JogoRepository jogoRepository;

    public JogoController(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> postMethodName(@RequestBody @Valid JogoDTO jogoDTO,
                                               UriComponentsBuilder uriComponentsBuilder) {
        Jogo jogo = jogoRepository.save(jogoDTO.toModel());

        URI location = uriComponentsBuilder.path(BASE_URI + "/{id}")
                                           .buildAndExpand(jogo.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

}
