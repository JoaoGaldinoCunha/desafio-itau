package br.com.desafio.desafio_itau.interfaceadpter.controller;

import br.com.desafio.desafio_itau.application.usercases.TrasacaoUseCase;
import br.com.desafio.desafio_itau.interfaceadpter.dto.request.TrasacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TrasacaoUseCase trasacaoUseCase;

    public TransacaoController(TrasacaoUseCase trasacaoUseCase) {this.trasacaoUseCase = trasacaoUseCase;}

    @PostMapping
    public ResponseEntity<?> salvarTransacao(TrasacaoDTO trasacaoDTO) {
        trasacaoUseCase.salvarTransacao(trasacaoDTO);
        return ResponseEntity.status(201).build();    }

    @DeleteMapping
    public ResponseEntity<?> deletarTransacao() {
        trasacaoUseCase.deletarTransacao();
        return ResponseEntity.ok().build();
    }


}
