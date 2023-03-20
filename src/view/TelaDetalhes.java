package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import control.*;

/**
 * A classe TelaDetalhes cria a interface gráfica para apresentar os atributos do programa específico
 * @author Felipe Hansen Arthur Campelo
 *
 */
public class TelaDetalhes implements ActionListener{
	private ControleDados dados;
	private JFrame janela = new JFrame("Canais de TV");
	private JLabel titulo = new JLabel("Detalhes do Programa");
	private JButton voltar = new JButton("Menu");
	private int id;
	
	public TelaDetalhes (int id, ControleDados d, String[] c, int posicao) {
		dados = d;
		this.id = id;
		JLabel descricao = new JLabel(c[posicao].toString());
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(140, 10, 270, 30);
		voltar.setBounds(300, 220, 120, 30);
		descricao.setBounds(10, 20, 1000, 200);
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(voltar);
		janela.add(descricao);
		// define o tamanho da janela 
		janela.setSize(500, 400);
		// fecha o programa quando o usuario fecha o programa
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltar.addActionListener(this);
	}
	/**
	 *  O método actionPerformed define os eventos a serem realizados pela classe
	 *  voltar leva para a TelaMenu
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == voltar) {
			new TelaMenu(id, dados);
			janela.dispose();
		}
	}

}
