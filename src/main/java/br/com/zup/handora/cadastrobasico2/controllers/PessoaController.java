package br.com.zup.handora.cadastrobasico2.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.cadastrobasico2.models.Pessoa;
import br.com.zup.handora.cadastrobasico2.models.PessoaDTO;
import br.com.zup.handora.cadastrobasico2.models.PessoaResponseDTO;
import br.com.zup.handora.cadastrobasico2.repositories.JogoRepository;
import br.com.zup.handora.cadastrobasico2.repositories.PessoaRepository;

@RestController
@RequestMapping(PessoaController.BASE_URI)
public class PessoaController {

    public final static String BASE_URI = "/pessoas";

    private final JogoRepository jogoRepository;
    private final PessoaRepository pessoaRepository;

    public PessoaController(JogoRepository jogoRepository, PessoaRepository pessoaRepository) {
        this.jogoRepository = jogoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PessoaDTO pessoaDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {

        Pessoa pessoa = pessoaRepository.save(pessoaDTO.toModel(jogoRepository));

        URI location = uriComponentsBuilder.path(BASE_URI + "/{id}")
                                           .buildAndExpand(pessoa.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> show(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findWithJogosById(id)
                                        .orElseThrow(
                                            () -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND,
                                                "Não existe uma pessoa com o id informado."
                                            )
                                        );

        return ResponseEntity.ok(new PessoaResponseDTO(pessoa));
    }

}
