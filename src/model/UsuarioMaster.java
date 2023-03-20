package model;
import java.util.ArrayList;
/**
 * Esta classe herda de Usuario e vai agregar objetos possuindo um booleam master 
 * @author Arthur e Felipe
 *
 */
public class UsuarioMaster extends Usuario {
	private boolean master;

	public UsuarioMaster(boolean master, ArrayList<Canal> listaCanaisFavoritos, ArrayList<Programa> listaProgramasGravados,
			String email, int id, String senha, ArrayList<Programa> listaProgramaOnAir, ArrayList<Canal> listaCanal) {
		super();
		this.master = master;
		this.listaProgramaOnAir = listaProgramaOnAir;
		this.listaCanal = listaCanal;
		this.email = email;
		this.id = id;
		this.senha = senha;
	}
	
	public boolean getMaster() {
		return master;
	}
	public void setMaster(boolean master) {
		this.master = master;
	}
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
	@Override
	public String toString() {
		String strOnAir = "";
		for (var i:listaProgramaOnAir) {
			strOnAir += i.getNome() + " ";
		}
		String strCanais = "";
		for (var i:listaCanal) {
			strCanais += i.getNome() + " ";
		}
		return "UsuarioMaster master=" + master + ", listaProgramaOnAir=" + strOnAir + ", listaCanal="
		+ strCanais + ", email=" + email + ", id=" + id + ", senha=" + senha + "";
	}
	
}