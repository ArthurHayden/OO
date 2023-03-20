package control;

import java.util.*;

import model.*;

/**
 * A classe ControleCanais é resposavel por interagir com os outros pacotes, models e view trocando dados ente si
 * @author Arthur Campelo Felipe Hansen
 *
 */

public class ControleCanais {
	private List<Canal> canais;
	private List<UsuarioPremium> listaUsuarioP;
	
	/**
	 *  O construtor recebe os dados  da model e transmite para view para listar os canais para usuario premium
	 *  @param
	 */
	public ControleCanais(ControleDados d) {
		canais = d.getCanais();
		listaUsuarioP = d.getListaUsuarioP();
		
	}
	/**
	 * Lista os canais favoritos de um usuario premium
	 * @param o numero de identificação do usuario
	 * @return String[]
	 */
	public String[] getListaCanaisFavoritos(int id) {
		String[] canaisFavoritos = {};
		for(var usuario:listaUsuarioP) {
			if(usuario.getId() == id) {
				canaisFavoritos = new String[usuario.getListaCanaisFavoritos().size()];
				for(int i = 0; i<usuario.getListaCanaisFavoritos().size(); i++) {
					canaisFavoritos[i] = (""+usuario.getListaCanaisFavoritos().get(i).getNome());
				}
				return canaisFavoritos;
			}
		}
		return canaisFavoritos;
	}

	/**
	 * metodo para listar canais de acordo com o nome
	 * @param nenhuma
	 * @return String[]
	 */
	public String[] getListaCanais() {
		String[] listaCanais = new String[canais.size()];
		for(int i = 0; i<canais.size(); i++) {
			listaCanais[i] = (""+canais.get(i).getNome());
		}
		return listaCanais;
	}
	/**
	 * metodo para listar canais de acordo com o numero
	 * @param nenhum
	 * @retunr String[]
	 */
	public String[] getNumeroListaCanais() {
		String[] listaCanais = new String[canais.size()];
		for(int i = 0; i<canais.size(); i++) {
			listaCanais[i] = (""+canais.get(i).getNumero());
		}
		return listaCanais;
	}
	/**
	 * metodo recebe uma lista da classe dados para cadatrar um novo canal a essa lista
	 * @param String[]
	 * @return boolean 
	 * 
	 */
	public boolean cadastrarCanal(String[] dados) {
		if(Integer.parseInt(dados[0]) < 0) {
			Canal channel = new Canal(dados[1], Integer.parseInt(dados[2]), new ArrayList<>());
			canais.add(channel);
		}else {
			Canal channel = new Canal(dados[1], Integer.parseInt(dados[2]), canais.get(Integer.parseInt(dados[0])).getListaProgramas()); 
			canais.set(Integer.parseInt(dados[0]), channel);
		}
		return true;
	}
	/**
	 * metodo recebe a posição de um canal para excluir
	 * @paran int
	 * @return void
	 */
	public void excluirCanal(int posicao) {
		canais.remove(posicao);
	}
}