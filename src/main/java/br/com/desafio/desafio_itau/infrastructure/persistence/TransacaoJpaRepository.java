package br.com.desafio.desafio_itau.infrastructure.persistence;

import br.com.desafio.desafio_itau.domain.entity.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoJpaRepository {
    private final List<Transacao> transacoes = new ArrayList<>();

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
