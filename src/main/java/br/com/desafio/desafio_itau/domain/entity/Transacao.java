package br.com.desafio.desafio_itau.domain.entity;


import java.util.Date;

public class Transacao {

    private Double valor;
    private java.util.Date date;

    public Transacao(Double valor, Date date) {
        valicaoValor(valor);
        dataValidacao(date);
        this.valor = valor;
        this.date = date;
    }

    public Double getValor() {return valor;}

    public void setValor(Double valor) {this.valor = valor;}

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public void valicaoValor(Double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    public void dataValidacao(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Data invalida");
        }
        if (date.before(this.date)) {
            throw new IllegalArgumentException("Data invalida");
        }
    }
}
