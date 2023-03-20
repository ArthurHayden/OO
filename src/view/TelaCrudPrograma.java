package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import control.*;

/**
 * A classe TelaCrudProgramas cria a interface gráfica da para fazer o crud de um programa
 * @author Felipe Hansen Arthur Campelo
 *
 */
public class TelaCrudPrograma implements ActionListener {
	private JFrame janela = new JFrame("CRUD");
	private JLabel tituloCanais = new JLabel("Canais");
	private JTextField nomePrograma;
	private JLabel nomeProgramalabel = new JLabel("Nome do Programa");
	private JTextField dataPrograma;
	private JLabel dataProgramalabel = new JLabel("Data do Programa");
	private JTextField horarioPrograma;
	private JLabel horarioProgramalabel = new JLabel("Horario do Programa");
	private JTextField descricaoPrograma;
	private JLabel descricaoProgramalabel = new JLabel("Descrição do Programa");
	private JButton voltar = new JButton("Voltar");
	private JButton addPrograma = new JButton("Add");
	private JButton salvar = new JButton("Salvar");
	private JButton excluir = new JButton("Excluir");
	private JList<String> listaCanais;
	private int p;
	
	private static ControleDados dados;
	
	public TelaCrudPrograma (ControleDados d, int posicao) {
		p=posicao;
		dados=d;
//		(posição do eixo x, posição no eixo y, tamanho do bloco na posição x, tamanho do bloco no eixo y)
		tituloCanais.setFont(new Font("Arial", Font.BOLD, 20));
		tituloCanais.setBounds(40, 20, 150, 30);
		
	
	
		listaCanais = new JList<String>(new ControleCanais(d).getListaCanais());
		
		janela.setLayout(null);
//		 define o tamanho da janela 
		janela.setSize(500, 600);
		// fecha o programa quando o usuario fecha o programa
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		if(posicao==-1) {
			nomePrograma = new JTextField(null);
			dataPrograma = new JTextField(null);
			horarioPrograma = new JTextField(null);
			descricaoPrograma = new JTextField(null);
			addPrograma.setBounds(270, 450, 100, 30);
			janela.add(addPrograma);
			janela.add(tituloCanais);
			voltar.setBounds(150, 520, 200, 30);
		}
		else {
			nomePrograma = new JTextField(new ControleProgramas(d).getAllListaProgramas()[posicao]);
			dataPrograma = new JTextField(new ControleProgramas(d).getAllInfosListaProgramas().get(posicao).getData());
			horarioPrograma = new JTextField(new ControleProgramas(d).getAllInfosListaProgramas().get(posicao).getHorario());//
			descricaoPrograma = new JTextField(new ControleProgramas(d).getAllInfosListaProgramas().get(posicao).getDescricao());
			salvar.setBounds(100, 500, 90, 30);
			janela.add(salvar);
			excluir.setBounds(210, 500, 90, 30);
			voltar.setBounds(320, 500, 90, 30);
			janela.add(excluir);
			
			
		}
		listaCanais.setBounds(40, 65, 190, 370);
		listaCanais.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaCanais.setVisibleRowCount(10);
		listaCanais.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		janela.add(listaCanais);
		janela.add(nomePrograma);
		nomePrograma.setBounds(260 , 110 , 200 , 30);
		
		janela.add(dataPrograma);
		dataPrograma.setBounds(260 , 175 , 200 , 30);
		
		
		janela.add(horarioPrograma);
		horarioPrograma.setBounds(260 , 240 , 200 , 30);
		
		
		janela.add(descricaoPrograma);
		descricaoPrograma.setBounds(260 , 305 , 200 , 30);
		
		
		nomeProgramalabel.setBounds(260 , 80 , 200 , 30);
		janela.add(nomeProgramalabel);
		
		dataProgramalabel.setBounds(260 , 145 , 200 , 30);
		janela.add(dataProgramalabel);
		
		horarioProgramalabel.setBounds(260 , 210 , 200 , 30);
		janela.add(horarioProgramalabel);
		
		descricaoProgramalabel.setBounds(260 , 275 , 200 , 30);
		janela.add(descricaoProgramalabel);
				
		janela.add(voltar);
		
		voltar.addActionListener(this);
		addPrograma.addActionListener(this);
		salvar.addActionListener(this);
		excluir.addActionListener(this);
		
	}
	/**
	 *  O método actionPerformed define os eventos a serem realizados pela classe
	 *  menu leva para pagina TelaCrud
	 *  add adiciona um novo programa e leva de volta para TelaCrud
	 *  salvar edita um programa e leva de volta para TelaCrud
	 *  excluir exclui um programa e leva de volta para TelaCrud
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		String valNomePrograma="";
		String valHorarioPrograma="";
		String valDataPrograma="";
		String valDescricaoPrograma="";
		String valNomeCanal="";
		valNomePrograma = nomePrograma.getText();
		valHorarioPrograma = horarioPrograma.getText();
		valDataPrograma = dataPrograma.getText();
		valDescricaoPrograma = descricaoPrograma.getText();
		valNomeCanal = listaCanais.getSelectedValue();
		ControleProgramas controleP = new ControleProgramas(dados);
		if(src == voltar) {
			new TelaCrud(dados);
			janela.dispose();
		}
		int flag;
		if(src == addPrograma || src == salvar) {
			if(valNomePrograma.isEmpty()|| valHorarioPrograma.isEmpty() ||valDataPrograma.isEmpty()|| valDescricaoPrograma.isEmpty()|| listaCanais.isSelectionEmpty()){
				JOptionPane.showMessageDialog(null,  "Todos os dados sao obrigatorios!",
						null, JOptionPane.ERROR_MESSAGE);	
			}
			else {
				if(src == salvar) {
					controleP.excluirPrograma(controleP.getAllListaProgramas()[p]);
				}
				flag=controleP.cadastrarPrograma(valNomeCanal, valNomePrograma, valDataPrograma, valHorarioPrograma, valDescricaoPrograma);
				if(flag==3) {
					JOptionPane.showMessageDialog(null,  "Este canal não existe",
							null, JOptionPane.ERROR_MESSAGE);
				}
				else if(flag==2) {
					JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
								JOptionPane.INFORMATION_MESSAGE);
					new TelaCrud(dados);
					janela.dispose();
				}
				else if(flag==1) {
					JOptionPane.showMessageDialog(null,  "Nome igual",
							null, JOptionPane.ERROR_MESSAGE);
				}
				else if(flag==4) {
					JOptionPane.showMessageDialog(null,  "Este canal não existe",
							null, JOptionPane.ERROR_MESSAGE);
				}
			}	
		}
		if(src == excluir) {
			controleP.excluirPrograma(valNomePrograma);
			new TelaCrud(dados);
			janela.dispose();
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		
	}

	
}	