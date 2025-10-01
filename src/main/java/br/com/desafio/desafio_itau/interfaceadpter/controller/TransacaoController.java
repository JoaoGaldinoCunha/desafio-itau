package br.com.desafio.desafio_itau.interfaceadpter.controller;

import br.com.desafio.desafio_itau.application.usercases.TrasacaoUseCase;
import br.com.desafio.desafio_itau.interfaceadpter.dto.request.TrasacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controller")
public class TransacaoController {
    private final TrasacaoUseCase trasacaoUseCase;

    public TransacaoController(TrasacaoUseCase trasacaoUseCase) {this.trasacaoUseCase = trasacaoUseCase;}

    public ResponseEntity<?> salvarTransacao(TrasacaoDTO trasacaoDTO) {
        trasacaoUseCase.salvarTransacao(trasacaoDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> trazerEstatiscas(){
        return ResponseEntity.ok(trasacaoUseCase.buscarEstaticas());
    }

}
