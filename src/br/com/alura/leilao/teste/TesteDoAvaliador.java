package br.com.alura.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.leilao.dominio.Avaliador;
import br.com.alura.leilao.dominio.Lance;
import br.com.alura.leilao.dominio.Leilao;
import br.com.alura.leilao.dominio.Usuario;

public class TesteDoAvaliador {
	@Test
	public  void deveEntenderLanceEmOrdemCrescente() {
		Usuario joao =  new Usuario("Joao");
		Usuario jose =  new Usuario("Jose");
		Usuario maria =  new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 NOVO");//criando o leilao.
		
		leilao.propoe(new Lance(joao, 250.0));//lance no leilao.
		leilao.propoe(new Lance(jose, 70.0));//lance no leilao.
		leilao.propoe(new Lance(maria, 1200.0));//lance no leilao.
		
		
		//Avaliador de Lance
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 1200;
		double menorEsperado = 70;

		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);

		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);


	}
}
