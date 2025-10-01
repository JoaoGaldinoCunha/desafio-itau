package br.com.desafio.desafio_itau.domain.repository;


import br.com.desafio.desafio_itau.domain.entity.Transacao;


public interface TransacaoRepository {

    public long buscarQtdUltimos60Segundos();

    public double buscarValorTotalUltimos60Segundos();

    public double buscarMediaUltimos60Segundos();

    public double buscarMinimoUltimos60Segundos();

    public double buscarMaximoUltimos60Segundos();

    public void salvar(Transacao transacao);
}
