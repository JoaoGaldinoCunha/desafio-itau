package br.com.desafio.desafio_itau.infrastructure.persistence;

import br.com.desafio.desafio_itau.domain.entity.Transacao;
import br.com.desafio.desafio_itau.domain.repository.TransacaoRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransacaoRepositoryImpl implements TransacaoRepository {

    private final TransacaoJpaRepository transacaoJpaRepository;

    public TransacaoRepositoryImpl(TransacaoJpaRepository transacaoJpaRepository) {
        this.transacaoJpaRepository = transacaoJpaRepository;
    }


    @Override
    public long buscarQtdUltimos60Segundos() {
        Date dataAtual = new Date();
        Date limite = new Date(dataAtual.getTime() - 60 * 1000);
        return transacaoJpaRepository
                .getTransacoes()
                .stream()
                .filter(transacao -> transacao.getDate().after(limite))
                .count();
    }


    @Override
    public double buscarValorTotalUltimos60Segundos() {
        Date dataAtual = new Date();
        Date limite = new Date(dataAtual.getTime() - 60 * 1000);
        return transacaoJpaRepository
                .getTransacoes()
                .stream()
                .filter(transacao -> transacao.getDate().after(limite))
                .mapToDouble(Transacao::getValor)
                .sum();

    }

    @Override
    public double buscarMediaUltimos60Segundos() {
        Date dataAtual = new Date();
        Date limite = new Date(dataAtual.getTime() - 60 * 1000);
        return transacaoJpaRepository
                .getTransacoes()
                .stream()
                .filter(transacao -> transacao.getDate().after(limite))
                .mapToDouble(Transacao::getValor)
                .average()
                .orElse(0.0);
    }

    @Override
    public double buscarMinimoUltimos60Segundos() {
        Date dataAtual = new Date();
        Date limite = new Date(dataAtual.getTime() - 60 * 1000);
        return transacaoJpaRepository
                .getTransacoes()
                .stream()
                .filter(transacao -> transacao.getDate().after(limite))
                .mapToDouble(Transacao::getValor)
                .min()
                .orElse(0.0);
    }

    @Override
    public double buscarMaximoUltimos60Segundos() {
        Date dataAtual = new Date();
        Date limite = new Date(dataAtual.getTime() - 60 * 1000);
        return transacaoJpaRepository
                .getTransacoes()
                .stream()
                .filter(transacao -> transacao.getDate().after(limite))
                .mapToDouble(Transacao::getValor)
                .max()
                .orElse(0.0);
    }

    @Override
    public void salvar(Transacao transacao) {
        try {
            transacaoJpaRepository.getTransacoes().add(transacao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletar() {
        transacaoJpaRepository.getTransacoes().clear();
    }


}
