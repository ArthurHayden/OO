package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import control.*;


/**
 * A classe TelaCanais cria a interface gráfica para listar todos os canais ou listar os canais favoritos
 * @author Felipe Hansen Arthur Campelo
 */

public class TelaCanais implements ActionListener, ListSelectionListener{
	private ControleDados dados;
	private JFrame janela = new JFrame("Canais de TV");
	private JLabel titulo = new JLabel("Lista de Canais");
	private JLabel favoritos = new JLabel("Canais Favoritos");
	private JButton voltar = new JButton("Voltar");
	private JList<String> listaCanais;
	private int id;
	private String nextPage;
	
	public TelaCanais(int id, ControleDados d, String pagina) {
		dados = d;
		this.id = id;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		if (pagina == "favoritos") {
			this.nextPage = "favoritos";
			janela.add(favoritos);
			listaCanais = new JList<String>(new ControleCanais(d).getListaCanaisFavoritos(id));
		}else{			
			this.nextPage = "canais";
			listaCanais = new JList<String>(new ControleCanais(d).getListaCanais());
		}
		titulo.setBounds(170, 10, 200, 30);
		voltar.setBounds(300, 220, 120, 30);
		favoritos.setFont(new Font("Arial", Font.BOLD, 17));
		favoritos.setBounds(280, 50, 250, 70);
		//(posição do eixo x, posição no eixo y, tamanho do bloco na posição x, tamanho do bloco no eixo y)
		listaCanais.setBounds(50, 65, 200, 250);
		listaCanais.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaCanais.setVisibleRowCount(10);
		listaCanais.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(voltar);
		janela.add(listaCanais);
		// define o tamanho da janela 
		janela.setSize(500, 400);
		// fecha o programa quando o usuario fecha o programa
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltar.addActionListener(this);
		listaCanais.addListSelectionListener(this);
	}
	/**
	 *  O método actionPerformed define os eventos a serem realizados pela classe
	 *  voltar leva para pagina TelaMenu
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == voltar) {
			new TelaMenu(id, dados);
			janela.dispose();
		}
	}
	/**
	 *  O método valueChanged define os eventos a serem realizados pela classe
	 *  o item clicado leva para pagina TelaProgramas de acordo com o canal clicado
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaCanais) {
			new TelaProgramas(id, dados, listaCanais.getSelectedIndex(), nextPage);
			janela.dispose();
		}

	}
}
