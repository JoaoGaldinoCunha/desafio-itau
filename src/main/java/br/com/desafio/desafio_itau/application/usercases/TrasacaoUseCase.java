package br.com.desafio.desafio_itau.application.usercases;

import br.com.desafio.desafio_itau.domain.entity.Transacao;
import br.com.desafio.desafio_itau.domain.repository.TransacaoRepository;
import br.com.desafio.desafio_itau.infrastructere.gateways.VerificarTrasicaoGeteway;
import br.com.desafio.desafio_itau.interfaceadpter.dto.response.EstatiscasDTO;
import br.com.desafio.desafio_itau.interfaceadpter.dto.request.TrasacaoDTO;
import br.com.desafio.desafio_itau.interfaceadpter.mapper.TransacaoMapper;
import org.springframework.stereotype.Service;

@Service
public class TrasacaoUseCase {
    private final VerificarTrasicaoGeteway verificarTrasicaoGeteway;
    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;

    public TrasacaoUseCase(VerificarTrasicaoGeteway verificarTrasicaoGeteway, TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper) {
        this.verificarTrasicaoGeteway = verificarTrasicaoGeteway;
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
    }

    public Transacao salvarTransacao(TrasacaoDTO transacao) {
        if (transacao.getDate() == null) {
            throw new RuntimeException("Data não pode ser nula.");
        }
        if (transacao.getDate().after(transacao.getDate())) {
        }
        if (transacao.getValor() == null) {
            throw new RuntimeException("Valor não pode ser nulo.");
        }
        if (transacao.getValor() < 0) {
            throw new RuntimeException("Valor deve ser maior que zero.");
        }

        if (!verificarTrasicaoGeteway.transacaoAprovada()) {
            throw new RuntimeException("Trasação não aprovada.");
        }

        Transacao toEntity = transacaoMapper.trasacaoDTOToEntity(transacao);
        transacaoRepository.salvar(toEntity);
        return toEntity;
    }

    public EstatiscasDTO buscarEstaticas() {
        long qtd = transacaoRepository.buscarQtdUltimos60Segundos();
        double total = transacaoRepository.buscarValorTotalUltimos60Segundos();
        double media = transacaoRepository.buscarMediaUltimos60Segundos();
        double minimo = transacaoRepository.buscarMinimoUltimos60Segundos();
        double maximo = transacaoRepository.buscarMaximoUltimos60Segundos();

        EstatiscasDTO estatiscasDTO = new EstatiscasDTO();
        estatiscasDTO.setQuantidade(qtd);
        estatiscasDTO.setValorTotal(total);
        estatiscasDTO.setMedia(media);
        estatiscasDTO.setMinimo(minimo);
        estatiscasDTO.setMaximo(maximo);

        return estatiscasDTO;
    }


}
