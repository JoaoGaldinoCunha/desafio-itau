package br.com.desafio.desafio_itau.infrastructure.persistence;

import br.com.desafio.desafio_itau.domain.entity.Transacao;

import java.util.List;

public class TransacaoJpaRepository {
    private  final List<Transacao> transacoes;

    public TransacaoJpaRepository(List<Transacao> transacoes) {this.transacoes = transacoes;}

    public List<Transacao> getTransacoes() {return transacoes;}
}
