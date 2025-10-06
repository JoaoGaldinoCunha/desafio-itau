package br.com.desafio.desafio_itau.interfaceadpter.mapper;

import br.com.desafio.desafio_itau.domain.entity.Transacao;
import br.com.desafio.desafio_itau.interfaceadpter.dto.request.TrasacaoDTO;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {

    public Transacao trasacaoDTOToEntity(TrasacaoDTO trasacaoDTO) {
         return new Transacao(trasacaoDTO.getValor(), trasacaoDTO.getDataHora());
    }

    public TrasacaoDTO entityToDTO(Transacao transacao) {
        return new TrasacaoDTO(transacao.getValor(), transacao.getDate());
    }
}
