package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import control.*;
/**
 * A classe TelaCrudCanal cria a interface gráfica da para fazer o crud de um canal
 * @author Felipe Hansen Arthur Campelo
 *
 */
public class TelaCrudCanal implements ActionListener{
	private ControleDados dados;
	private JFrame janela = new JFrame("Programação televisão");
	private JLabel titulo = new JLabel("Adicionar Canal");
	private JTextField nome , numero;
	private JLabel  nomeLabel , numeroLabel;
	private JButton salvar = new JButton("Salvar");
	private JButton excluir = new JButton("Excluir");
	private JButton add = new JButton("Add");
	private JButton menu = new JButton("Menu");
	private int p;
	
	public TelaCrudCanal(ControleDados d, int posicao) {
		dados=d;
		this.p=posicao;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 10, 200, 30);
		janela.setLayout(null);
		janela.setSize(500, 400);
		// fecha o programa quando o usuario fecha o programa
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		if(posicao == -1) {
			nome = new JTextField(null);
			numero = new JTextField(null);
			add.setBounds(150, 160, 200, 30);
			janela.add(add);
		}else {
			nome = new JTextField(new ControleCanais(d).getListaCanais()[posicao]);//
			numero = new JTextField(new ControleCanais(d).getNumeroListaCanais()[posicao]);
			salvar.setBounds(150, 160, 90, 30);
			janela.add(salvar);
			excluir.setBounds(260, 160, 90, 30);
			janela.add(excluir);
		}
		menu.setBounds(150, 200, 200, 30);
		janela.add(menu);
		
		nomeLabel = new JLabel(" Nome :");
		numeroLabel = new JLabel(" Número : ");
		
		janela.add(titulo);
		janela.add(nomeLabel);
		janela.add(nome);
		janela.add(numeroLabel);
		janela.add(numero);
		nomeLabel.setBounds(100 , 70 , 90 , 30);
		nome.setBounds(170 , 70 , 200 , 30);
		
		numeroLabel.setBounds(100 , 110 , 90 , 30);
		numero.setBounds(170 , 110 , 200 , 30);
		
		add.addActionListener(this);
		menu.addActionListener(this);
		salvar.addActionListener(this);
		excluir.addActionListener(this);
	}
	/**
	 *  O método actionPerformed define os eventos a serem realizados pela classe
	 *  menu leva para pagina TelaCrud
	 *  add adiciona um novo canal e leva de volta para TelaCrud
	 *  salvar edita um canal e leva de volta para TelaCrud
	 *  excluir exclui um canal e leva de volta para TelaCrud
	 */
	public void actionPerformed(ActionEvent e) {
		ControleCanais controleC = new ControleCanais(dados);
		Object src = e.getSource();
		String valorNome = nome.getText();
		String valorNumero = numero.getText();
		
		if(src == menu) {
			new TelaCrud(dados);
			janela.dispose();
		}
		if(src == add || src == salvar) {
			if (valorNome.isEmpty() || valorNumero.isEmpty()) {
				JOptionPane.showMessageDialog(null,  "Todos os dados sao obrigatorios!",
						null, JOptionPane.ERROR_MESSAGE);	
			}
			else {
				try {
					boolean sucesso;
					String[] dadosCanal = new String[3];
					dadosCanal[0] =  Integer.toString(p);
					dadosCanal[1] =  valorNome;
					dadosCanal[2] =  valorNumero;
					
					sucesso = controleC.cadastrarCanal(dadosCanal);
	
					if(sucesso) {
						mensagemSucessoCadastro();
					}else {
						mensagemErroCadastro();
					}
				} catch (NullPointerException exc1) {
					mensagemErroCadastro();
				} catch (NumberFormatException exc2) {
					mensagemErroCadastro();
				}
			}
		}
		if(src == excluir) {
			controleC.excluirCanal(p);
			new TelaCrud(dados);
			janela.dispose();
		}
		
	}
	/**
	 * O método mensagemSucessoCadastro gera um aviso se o cadastro foi feito com sucesso
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		new TelaCrud(dados);
		janela.dispose();
	}
	/**
	 * O método mensagemErroCadastro gera um aviso se o cadastro deu erro
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Algum campo foi preenchido incorretamente\n", null,
				JOptionPane.ERROR_MESSAGE);
	}
}
