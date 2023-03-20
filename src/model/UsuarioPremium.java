package model;
import java.util.ArrayList;
/**
 * Esta classe herda de Usuario e vai agregar obejtos possuindo uma lista canais favoritos um nome
 * @author Arthur Felipe
 *
 */
public class UsuarioPremium extends Usuario{
	private ArrayList<Canal> listaCanaisFavoritos;
	private String nome;
	
	
	public UsuarioPremium(ArrayList<Canal> listaCanaisFavoritos, String nome, String email,
			int id, String senha, ArrayList<Programa> listaProgramaOnAir, ArrayList<Canal> listaCanal) {
		super();
		this.listaCanaisFavoritos = listaCanaisFavoritos;
		this.nome = nome;
		this.email = email;
		this.id = id;
		this.senha = senha;
		this.listaProgramaOnAir = listaProgramaOnAir;
		this.listaCanal = listaCanal;
	}


	public ArrayList<Canal> getListaCanaisFavoritos() {
		return listaCanaisFavoritos;
	}

	public void setListaCanaisFavoritos(ArrayList<Canal> listaCanaisFavoritos) {
		this.listaCanaisFavoritos = listaCanaisFavoritos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	@Override
	public String toString() {
		String strFavCanais = "";
		for (var i:listaCanaisFavoritos) {
			strFavCanais += i.getNome() + " ";
		}
		String strOnAir = "";
		for (var i:listaProgramaOnAir) {
			strOnAir += i.getNome() + " ";
		}
		String strCanais = "";
		for (var i:listaCanal) {
			strCanais += i.getNome() + " ";
		}
		String str = "UsuarioPremium " + nome + ", listaCanaisFavoritos= " + strFavCanais + 
				", email=" + email + ", id=" + id + ", senha=" + senha + ", listaProgramaOnAir= " + strOnAir + ", listaCanal= " + strCanais;
		return str;
	}
}