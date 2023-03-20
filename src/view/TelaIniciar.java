package view;

import control.*;

/**
 * A classe TelaInicial instancia o a classe de Dados e chama a TelaLogin
 * @author Felipe Hansen Arthur Campelo
 *
 */
public class TelaIniciar {
	private static ControleDados dados = new ControleDados();
	
	public static void main(String[] args) {
		new TelaIniciar();
		new TelaLogin(dados);
	}
}
