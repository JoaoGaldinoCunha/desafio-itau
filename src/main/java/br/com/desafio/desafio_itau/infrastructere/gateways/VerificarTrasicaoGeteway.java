package br.com.desafio.desafio_itau.infrastructere.gateways;

import br.com.desafio.desafio_itau.application.geteways.TrasicaoGateway;

public class VerificarTrasicaoGeteway implements TrasicaoGateway {

    @Override
    public boolean transacaoAprovada(){
       double aprovadaOuNao = Math.floor(Math.random() * 2);
        if(aprovadaOuNao == 0){
            return false;
        }
        return true;
    }

}
