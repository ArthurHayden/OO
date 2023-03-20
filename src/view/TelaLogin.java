
package view;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import control.*;
/**
 * A classe TelaLogin cria a interface gráfica para fazer login no programa
 * @author Felipe Hansen Arthur Campelo
 *
 */
public class TelaLogin implements ActionListener{
	private ControleDados dados;
	private JFrame janela = new JFrame("Programação televisão");
	private JLabel titulo = new JLabel("Login");
	private JCheckBox master, premium;
	private JLabel  emailLabel , senhaLabel;
	private JTextField email , senha;
	private JButton enviar;
	
	
	public TelaLogin(ControleDados d) {
		dados = d;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(200, 10, 150, 30);
		
		//(posição do eixo x, posição no eixo y, tamanho do bloco na posição x, tamanho do bloco no eixo y)
		
		janela.setLayout(null);
		janela.add(titulo);
		master = new JCheckBox("Master");
		premium = new JCheckBox("Premium");
		
		emailLabel = new JLabel(" Email :");
		senhaLabel = new JLabel(" Senha : ") ;
		
		// define o tamanho da janela 
		
		
		email = new JTextField(null);
		senha = new JTextField(null);
	
		janela.setSize(500, 400);
		enviar = new JButton(" Enviar ");
		
		
		emailLabel.setBounds(100 , 70 , 90 , 30);
		email.setBounds(160 , 70 , 200 , 30);
		
		senhaLabel.setBounds(100 , 110 , 90 , 30);
		senha.setBounds(160 , 110 , 200 , 30);
		enviar.setBounds(140 , 200 , 200 , 30);
		master.setBounds(140 , 160 , 100 , 20);
		premium.setBounds(250 , 160 , 100 , 20);
		
		ButtonGroup group = new ButtonGroup();
		group.add(master);
		group.add(premium);
		janela.add(master);
		janela.add(premium);
		janela.add(emailLabel );
		janela.add( email );
		janela.add(senhaLabel);
		janela.add( senha );
		
		janela.add( enviar );
		
				
		// fecha o programa quando o usuario fecha o programa
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		enviar.addActionListener( this );
	}
	/**
	 *  O método actionPerformed define os eventos a serem realizados pela classe
	 *  enviar faz login em Premium ou Master e verifica os campos
	 */
	public void actionPerformed(ActionEvent e) {
		ControleUsuario u = new ControleUsuario(dados);
		Object src = e.getSource();
		String valoremail=null;
		String valorsenha=null;
		valoremail = email.getText();
		valorsenha = senha.getText();
		
		if (src == enviar) {
			if(premium.isSelected()) {
				if(u.login(valoremail,valorsenha)==-1 && valoremail.isEmpty()!=true && valorsenha.isEmpty()!=true) {
					JOptionPane.showMessageDialog(null,  "email ou senha invalidos !",
							null, JOptionPane.ERROR_MESSAGE);
				}
				else if ( valoremail.isEmpty() || valorsenha.isEmpty()) {
					JOptionPane.showMessageDialog(null,  "Todos os dados sao obrigatorios!",
							null, JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(u.login(valoremail,valorsenha)!=-1) {
					new TelaMenu(u.login(valoremail,valorsenha), dados);
					janela.dispose();
					
				}				
			}
			else if(master.isSelected()) {
				if(u.loginMaster(valoremail,valorsenha)==-1 && valoremail.isEmpty()!=true && valorsenha.isEmpty()!=true) {
					JOptionPane.showMessageDialog(null,  "email ou senha invalidos !",
							null, JOptionPane.ERROR_MESSAGE);
				}
				else if ( valoremail.isEmpty() || valorsenha.isEmpty()) {
					JOptionPane.showMessageDialog(null,  "Todos os dados sao obrigatorios!",
							null, JOptionPane.ERROR_MESSAGE);	
				}
				
				else if(u.loginMaster(valoremail,valorsenha)!=-1) {
					new TelaCrud(dados);
					janela.dispose();
					
				}				
			}
			else {
				JOptionPane.showMessageDialog(null,  "Todos os dados sao obrigatorios!",
						null, JOptionPane.ERROR_MESSAGE);	
			}
			
			email.setText(valoremail);
			senha.setText(valorsenha);
			
		}
		
	}
}