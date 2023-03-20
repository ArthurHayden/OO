package model;
import java.util.ArrayList;
/**
 * Esta classe é abstrata Usuario define o modelo que os UsuariosPremium e UsuarioMaster devem ser seguidos
 * @author Felipe Hansen Arthur Campelo
 *
 */
public abstract class Usuario {
	protected ArrayList<Programa> listaProgramaOnAir;
	protected ArrayList<Canal> listaCanal;
	protected String email;
	protected int id;
	protected String senha;
	
	public ArrayList<Programa> getListaProgramaOnAir() {
		return listaProgramaOnAir;
	}
	public void setListaProgramaOnAir(ArrayList<Programa> listaProgramaOnAir) {
		this.listaProgramaOnAir = listaProgramaOnAir;
	}
	public ArrayList<Canal> getListaCanal() {
		return listaCanal;
	}
	public void setListaCanal(ArrayList<Canal> listaCanal) {
		this.listaCanal = listaCanal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}