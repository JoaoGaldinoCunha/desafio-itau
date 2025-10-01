package br.com.desafio.desafio_itau.interfaceadpter.dto.response;

public class EstatiscasDTO {
    public long quantidade;
    public double valorTotal;
    public double media;
    public double minimo;
    public double maximo;

    public long getQuantidade() {return quantidade;}

    public void setQuantidade(long quantidade) {this.quantidade = quantidade;}

    public double getValorTotal() {return valorTotal;}

    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}

    public double getMedia() {return media;}

    public void setMedia(double media) {this.media = media;}

    public double getMinimo() {return minimo;}

    public void setMinimo(double minimo) {this.minimo = minimo;}

    public double getMaximo() {return maximo;}

    public void setMaximo(double maximo) {this.maximo = maximo;}


}
