package model;
/**
 * Esta classe vai agregar objetos e possui nome, data , horario e descrição
 * @author Arthur Felipe 
 *
 */
public class Programa {
	private String nome;
	private String data;
	private String horario;
	private String descricao;
	
	public Programa(String nome, String data, String horario, String descricao) {
		super();
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.descricao = descricao;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(nome + " - Data: " + data + "\n");
		sb.append(" - Horário: " + horario + "\n");
		sb.append(" - Descrição: " + descricao + "\n");
		
		return sb.toString();
		
	}
	
}