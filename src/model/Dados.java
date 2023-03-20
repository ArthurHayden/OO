package model;
import java.util.ArrayList;
import java.util.List;
/**
 * Esta classe possui todos os dados dos canais, programas e usuarios iniciais 
 * @author Arthur e Felipe
 *
 */
public class Dados {
	
	private List<Canal> canais = new ArrayList<Canal>();
	private List<Programa> programas = new ArrayList<Programa>();
	private List<UsuarioPremium> listaUsuarioP = new ArrayList<UsuarioPremium>();
	private List<UsuarioMaster> listaUsuarioM = new ArrayList<UsuarioMaster>();
	private List<Programa> programasOnAir = new ArrayList<Programa>();
	private UsuarioMaster master;
	private UsuarioPremium premium1;
	private UsuarioPremium premium2;
	private UsuarioPremium premium3;
	private UsuarioPremium premium4;
	
	public void cadastrosProntos () {
		
		Programa filme =  new Programa("Harry Potter", "11/12/2022", "22:00", "bruxos contra viloes");
		Programa novela =  new Programa("Avenida Brasil", "11/12/2022", "21:00", "Carminha x Nina");
		Programa bbb =  new Programa("BBB", "11/12/2022", "22:00", "reality");
		Programa got =  new Programa("Game of Thrones", "26/12/2022", "23:00", "dragoes e Casas");
		Programa filme2 =  new Programa("Senhor dos Aneis", "11/12/2022", "20:00", "filme ficçao cientifica");
		Programa globonews =  new Programa("Globo News", "26/12/2022", "21:00", "noticias de hoje");
		Programa padrinhosMagicos =  new Programa("Padrinhos Magicos", "26/12/2022", "19:00", "timmy perde seus padrinhos");
		Programa ben =  new Programa("Ben 10", "12/12/2022", "22:00", "ben 10 vs vilgaguis");
		Programa cloneWars =  new Programa("Clone Wars", "16/12/2022", "23:00", "A volta do Darth Maul");
		Canal globo = new Canal("Globo", 10, new ArrayList<>());
		Canal telecine = new Canal("Telecine", 223, new ArrayList<>());
		Canal cartoom = new Canal("Cartoon", 46, new ArrayList<>());
		Canal nick = new Canal("Nick", 44, new ArrayList<>());
		Canal disney = new Canal("Disney", 67, new ArrayList<>());
		
		premium1 = new UsuarioPremium(new ArrayList<>(), "Jose", "a", 0005, "1", new ArrayList<>(), new ArrayList<>());
		premium2 = new UsuarioPremium(new ArrayList<>(), "Athur", "bbbb@gmail.com", 0002, "12345", new ArrayList<>(), new ArrayList<>());
		premium3 = new UsuarioPremium(new ArrayList<>(), "Professora", "cccc@gmail.com", 0003, "12345", new ArrayList<>(), new ArrayList<>());
		premium4 = new  UsuarioPremium(new ArrayList<>(), "Felipe", "aaaaa@gmail.com", 4, "12345", new ArrayList<>(), new ArrayList<>());
		master = new UsuarioMaster(true, new ArrayList<>(), new ArrayList<>(), "b", 5, "2", new ArrayList<>(), new ArrayList<>());
		
		//* Adicionando canais e adicionando os programas em cada um
		canais.add(globo);
		canais.add(telecine);
		canais.add(nick);
		canais.add(cartoom);
		canais.add(disney);
		
		
		globo.getListaProgramas().add(globonews);
		globo.getListaProgramas().add(novela);
		globo.getListaProgramas().add(bbb);
		
		telecine.getListaProgramas().add(filme2);
		telecine.getListaProgramas().add(filme);
		telecine.getListaProgramas().add(got);

		nick.getListaProgramas().add(padrinhosMagicos);
		cartoom.getListaProgramas().add(ben);
		disney.getListaProgramas().add(cloneWars);
			
		listaUsuarioP.add(premium1);
		listaUsuarioP.add(premium2);
		listaUsuarioP.add(premium3);
		listaUsuarioP.add(premium4);
		listaUsuarioM.add(master);
		
		programasOnAir.add(globonews);
		programasOnAir.add(filme2);
		programasOnAir.add(ben);

		premium1.getListaCanaisFavoritos().add(telecine);
		premium1.getListaCanaisFavoritos().add(disney);
		premium2.getListaCanaisFavoritos().add(globo);
		premium2.getListaCanaisFavoritos().add(telecine);

	}

	public List<Canal> getCanais() {
		return canais;
	}

	public void setCanais(List<Canal> canais) {
		this.canais = canais;
	}

	public List<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	public List<UsuarioPremium> getListaUsuarioP() {
		return listaUsuarioP;
	}

	public void setListaUsuarioP(List<UsuarioPremium> listaUsuarioP) {
		this.listaUsuarioP = listaUsuarioP;
	}

	public List<UsuarioMaster> getListaUsuarioM() {
		return listaUsuarioM;
	}

	public void setListaUsuarioM(List<UsuarioMaster> listaUsuarioM) {
		this.listaUsuarioM = listaUsuarioM;
	}

	public List<Programa> getProgramasOnAir() {
		return programasOnAir;
	}

	public void setProgramasOnAir(List<Programa> programasOnAir) {
		this.programasOnAir = programasOnAir;
	}

	public UsuarioMaster getMaster() {
		return master;
	}

	public void setMaster(UsuarioMaster master) {
		this.master = master;
	}

	public UsuarioPremium getPremium1() {
		return premium1;
	}

	public void setPremium1(UsuarioPremium premium1) {
		this.premium1 = premium1;
	}

	public UsuarioPremium getPremium2() {
		return premium2;
	}

	public void setPremium2(UsuarioPremium premium2) {
		this.premium2 = premium2;
	}

	public UsuarioPremium getPremium3() {
		return premium3;
	}

	public void setPremium3(UsuarioPremium premium3) {
		this.premium3 = premium3;
	}

	public UsuarioPremium getPremium4() {
		return premium4;
	}

	public void setPremium4(UsuarioPremium premium4) {
		this.premium4 = premium4;
	}
	
}