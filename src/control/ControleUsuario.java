package control;

import java.text.SimpleDateFormat;
import java.util.*;

import model.*;
/**
 * Esta classe ControleUsuario faz o controle dos Usuarios para os pacotes de view e controle 
 * @author Felipe Hansen Arthur Campelo
 *
 */

public class ControleUsuario {
	public List<UsuarioPremium> listaUsuarioP;
	public List<UsuarioMaster> listaUsuarioM;
	
	/**
	 * Este construtor instancia lista de Usuarios premium e Master para lista-los
	 * @param controle de dadados d
	 */
	public ControleUsuario(ControleDados d) {
		listaUsuarioP = d.getListaUsuarioP();
		listaUsuarioM = d.getListaUsuarioM();
		
	}
	/**
	 * Este metodo serve para buscar um usuario premium 
	 * @param email String[]
	 * @param senha String[]
	 * @retunr int 
	 */
	public int login(String email, String senha){
		for(var usuario:listaUsuarioP) 
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha))
				return usuario.getId();
		return -1;
	}
	/**
	 * Este metodo serve para buscar um usuario Master
	 * @param email String[]
	 * @param senha String[]
	 * @retunr int 
	 */
	public int loginMaster(String email, String senha){
		for(var usuario:listaUsuarioM) 
			if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha))
				return usuario.getId();
		return -1;
	}

}