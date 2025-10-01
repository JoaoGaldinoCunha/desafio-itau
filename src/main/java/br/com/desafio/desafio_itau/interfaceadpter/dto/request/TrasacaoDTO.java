package br.com.desafio.desafio_itau.interfaceadpter.dto.request;

import java.util.Date;

public class TrasacaoDTO {
    private Double valor;
    private Date date;

    public TrasacaoDTO(Double valor, Date data) {
        this.valor = valor;
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
