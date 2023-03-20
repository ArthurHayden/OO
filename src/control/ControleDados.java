package control;

import java.text.SimpleDateFormat;
import java.util.*;

import model.*;
/**
 * Esta classe ControleDados serve para controlar os dados entre os pacotes view e control
 * @author Arthur e Felipe
 *
 */

public class ControleDados {
	private Dados d = new Dados();
	
	/**
	 * esse construtor instancia os cadastros prontos setados na classe Dados
	 */
	public ControleDados() {
		d.cadastrosProntos();
	}
	/**
	 * estancia lista de canais 
	 */
	public List<Canal> getCanais() {
		return this.d.getCanais();
	}
	/**
	 * estancia os programas
	 */
	public List<Programa> getProgramas() {
		return this.d.getProgramas();
	}
	/**
	 * estancia os programasOnAir
	 */
	public List<Programa> getProgramasOnAir() {
		return this.d.getProgramasOnAir();
	}
	/**
	 * estancia os Usuarios premium
	 */
	public List<UsuarioPremium> getListaUsuarioP() {
		return this.d.getListaUsuarioP();
	}
	/**
	 * estancia os Usuarios Master 
	 */
	public List<UsuarioMaster> getListaUsuarioM() {
		return this.d.getListaUsuarioM();
	}
	/**
	 * Faz o toString
	 * @return controle de dados
	 */
	@Override
	public String toString() {
		return "ControleDados [d=" + d + "]";
	}
	
}