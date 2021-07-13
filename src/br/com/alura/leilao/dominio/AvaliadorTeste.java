package br.com.alura.leilao.dominio;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTeste {
@Test
    public void LancesEmOrdemCrescente() {
        //Usuarios   
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        //Produto do leilão
        Leilao leilao = new Leilao("PlayStation");
        
        //Lances do leilão
        leilao.propoe(new Lance(maria, 250));
        leilao.propoe(new Lance(joao, 300));
        leilao.propoe(new Lance(jose, 400));

        //Avaliador
        Avaliador leiloeiro = new Avaliador();
        leilao.avalia(leilao);


        //comparando a saída
        double maiorEsperado = 400;
        double menorEsperado = 250;

    Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
    Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
    }

    @SuppressWarnings("deprecation")
	@Test
    public void deveEntenderLeilaoComAPenasUmLance(){
        Usuario joao = new Usuario("Joao");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        Assert.assertEquals(1000.0, leiloeiro.getMenorLance());
        Assert.assertEquals(1000.0, leiloeiro.getMenorLance());

    }
}
