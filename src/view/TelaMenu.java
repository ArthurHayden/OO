package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import control.*;

/**
 * A classe TelaMenu cria a interface gráfica do menu do programa para os UsuarioPremium
 * @author Felipe Hansen Arthur Campelo
 *
 */
public class TelaMenu implements ActionListener{
	private JFrame janela = new JFrame("Programação de TV");
	private JLabel titulo = new JLabel("Menu Principal");
	private JButton canais = new JButton("Canais");
	private JButton programas = new JButton("Programas");
	private JButton favoritos = new JButton("Canais Favoritos");
	private JButton sair = new JButton("Sair");
	private ControleDados dados;
	private int id;
	
	
	public TelaMenu(int id, ControleDados d) {
		dados = d;
		this.id = id;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(170, 10, 250, 30);
		canais.setBounds(150, 70, 200, 30);
		programas.setBounds(150, 120, 200, 30);
		//(posição do eixo x, posição no eixo y, tamanho do bloco na posição x, tamanho do bloco no eixo y)
		favoritos.setBounds(150, 170, 200, 30);
		sair.setBounds(150, 220, 200, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(canais);
		janela.add(programas);
		janela.add(favoritos);
		janela.add(sair);
		// define o tamanho da janela 
		janela.setSize(500, 400);
		// fecha o programa quando o usuario fecha o programa
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		canais.addActionListener(this);
		sair.addActionListener(this);
		favoritos.addActionListener(this);
		programas.addActionListener(this);
	}
	
	/**
	 *  O método actionPerformed define os eventos a serem realizados pela classe
	 *  canais leva para pagina de TelaCanais
	 *  programas leva para pagina de TelaProgramas
	 *  favoritos leva para pagina DE TelaCanais com os canais favoritos
	 *  sair leva para pagina de TelaLogin
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == canais) {
			new TelaCanais(id, dados, "canais");
			janela.dispose();
		}
		if(src == programas) {
//			ControleCanais controle = new ControleCanais(d);
			new TelaProgramas(id, dados, 0, "onAir");
			janela.dispose();
		}
		if(src == favoritos) {
			new TelaCanais(id, dados, "favoritos");
			janela.dispose();
		}
		if(src == sair) {
			new TelaLogin(dados);
			janela.dispose();
		}
	}
	
}