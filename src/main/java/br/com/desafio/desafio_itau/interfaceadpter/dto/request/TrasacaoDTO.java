package br.com.desafio.desafio_itau.interfaceadpter.dto.request;

import java.util.Date;

public class TrasacaoDTO {
    private Double valor;
    private Date dataHora;

    public TrasacaoDTO(Double valor, Date dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
