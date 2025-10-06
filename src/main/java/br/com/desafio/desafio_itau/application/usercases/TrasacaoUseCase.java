package br.com.desafio.desafio_itau.application.usercases;

import br.com.desafio.desafio_itau.domain.entity.Transacao;
import br.com.desafio.desafio_itau.domain.repository.TransacaoRepository;
import br.com.desafio.desafio_itau.infrastructure.gateways.VerificarTrasicaoGeteway;
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
        if (transacao.getDataHora() == null) {
            throw new RuntimeException("Data não pode ser nula.");
        }
        if (transacao.getDataHora().after(transacao.getDataHora())) {
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





}
