package br.com.desafio.desafio_itau.interfaceadpter.controller;

import br.com.desafio.desafio_itau.application.usercases.EstatisicasUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controller/estatisticas")
public class EstatisticasController {
    private final EstatisicasUseCase estatiscasUseCase;

    public EstatisticasController(EstatisicasUseCase estatiscasUseCase) {this.estatiscasUseCase = estatiscasUseCase;}

    @GetMapping
    public ResponseEntity<?> trazerEstatiscas(){
        return ResponseEntity.ok(estatiscasUseCase.buscarEstaticas());
    }

}
