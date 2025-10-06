package br.com.desafio.desafio_itau.application.usercases;

import br.com.desafio.desafio_itau.domain.repository.TransacaoRepository;
import br.com.desafio.desafio_itau.infrastructure.gateways.VerificarTrasicaoGeteway;
import br.com.desafio.desafio_itau.interfaceadpter.dto.response.EstatiscasDTO;
import br.com.desafio.desafio_itau.interfaceadpter.mapper.TransacaoMapper;
import org.springframework.stereotype.Service;

@Service
public class EstatisicasUseCase {
    private final VerificarTrasicaoGeteway verificarTrasicaoGeteway;
    private final TransacaoRepository transacaoRepository;

    public EstatisicasUseCase(VerificarTrasicaoGeteway verificarTrasicaoGeteway, TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper) {
        this.verificarTrasicaoGeteway = verificarTrasicaoGeteway;
        this.transacaoRepository = transacaoRepository;
    }


    public EstatiscasDTO buscarEstaticas() {
        long qtd = transacaoRepository.buscarQtdUltimos60Segundos();
        double total = transacaoRepository.buscarValorTotalUltimos60Segundos();
        double media = transacaoRepository.buscarMediaUltimos60Segundos();
        double minimo = transacaoRepository.buscarMinimoUltimos60Segundos();
        double maximo = transacaoRepository.buscarMaximoUltimos60Segundos();

        EstatiscasDTO estatiscasDTO = new EstatiscasDTO();
        estatiscasDTO.setCount(qtd);
        estatiscasDTO.setSum(total);
        estatiscasDTO.setAvg(media);
        estatiscasDTO.setMin(minimo);
        estatiscasDTO.setMax(maximo);

        return estatiscasDTO;
    }


}
