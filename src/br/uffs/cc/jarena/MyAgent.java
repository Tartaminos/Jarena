// Johann Simon Hoffmann 
// Bruno Vieira Florisbal

package br.uffs.cc.jarena;

import java.util.*;

public class MyAgent extends Agente {

	public MyAgent(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(geraDirecaoAleatoria());
	}

	public void pensa() {
		// Se não conseguimos nos mover para a direção atual, quer dizer
		// que chegamos no final do mapa ou existe algo bloqueando nosso
		// caminho.
		if (!podeMoverPara(getDirecao())) {
			setDirecao(geraDirecaoAleatoria());
		}
		enviaMensagem(String.valueOf(getDirecao()));
		// Se o agente conseguie se dividir (tem energia) e se o total de energia
		// do agente é maior que 400, nos dividimos. O agente filho terá a metade
		// da nossa energia atual.
		if (podeDividir() && getEnergia() >= 800) {
			divide();
		}
	}

	public void recebeuEnergia() {
		setDirecao(geraDirecaoAleatoria());
		// Invocado sempre que o agente recebe energia.
	}

	public void tomouDano(int energiaRestanteInimigo) {
		setDirecao(geraDirecaoAleatoria());
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).
	}

	public void ganhouCombate() {
		setDirecao(geraDirecaoAleatoria());
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}

	public void recebeuMensagem(String msg) {
		// Invocado sempre que um agente aliado próximo envia uma mensagem.
	}

	public String getEquipe() {
		// Definimos que o nome da equipe do agente é "Fernando".
		return "My Agent";
	}

}