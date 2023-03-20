package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import control.*;

import static org.junit.Assert.assertArrayEquals;
/**
 * A classe TestesUnitarios realiza os testes da aplicação, verificando se os valores de retorno dos métodos
 * esta igual aos esperados 
 * do programa
 * @author Arthur e Felipe
 *
 */
public class TestesUnitarios {

/**
 * O metodo testegetBuscaPrograma vai verificar se oque é retornado do metodo getBuscaPrograma é o esperado
 */
	@Test
	void testBuscarPrograma() {
		String programa1 = "BBB";
		String programa2 = "Ben 10";
		String programa3 = "Game of Thrones";
		String programa4 = "Harry Potter";
		String programa5 = "Rebelde";
		int[] prog1 = {0,2};
		int[] prog2 = {3,0};
		int[] prog3 = {1,2};
		int[] prog4 = {1,1};
		int[] prog5 = {-1,-2};
		
		ControleDados d = new ControleDados();
		ControleProgramas controleProgramas = new ControleProgramas(d);
		assertArrayEquals(prog1, controleProgramas.getBuscaPrograma(programa1));
		assertArrayEquals(prog2,controleProgramas.getBuscaPrograma(programa2));
		assertArrayEquals(prog3,controleProgramas.getBuscaPrograma(programa3));
		assertArrayEquals(prog4,controleProgramas.getBuscaPrograma(programa4));
		assertArrayEquals(prog5,controleProgramas.getBuscaPrograma(programa5));
	}
	/**
	 *  O metodo testCadastrarCanal vai verificar se oque é retornado do metodo CadastrarCanal é o esperado
	 */
	@Test
	void testCadastrarCanal() {
		
		String[] dadosCanal1 = new String[3];
		String[] dadosCanal2 = new String[3];
		String[] dadosCanal3 = new String[3];
		int p=-1;
		dadosCanal1[0] =  Integer.toString(p);
		dadosCanal1[1] =  "Kids";
		dadosCanal1[2] =  "90";
		
		dadosCanal2[0] =  Integer.toString(p);
		dadosCanal2[1] =  "SBT";
		dadosCanal2[2] =  "12";
		
		dadosCanal3[0] =  Integer.toString(p);
		dadosCanal3[1] =  "Fox";
		dadosCanal3[2] =  "56";
		ControleDados d = new ControleDados();
		ControleCanais controleCanais = new ControleCanais(d);
		assertTrue(controleCanais.cadastrarCanal(dadosCanal1));
		assertTrue(controleCanais.cadastrarCanal(dadosCanal2));
		assertTrue(controleCanais.cadastrarCanal(dadosCanal3));
	}
	/**
	 *  O metodo testCadastarPrograma vai verificar se oque é retornado do metodo CadastarPrograma é o esperado
	 */
	@Test
	void testCadastarPrograma(){
		String canal = "Nick";
		String NomePrograma1 = "RBD";
		String horarioPrograma1 = "21:00";
		String dataPrograma1 = "28/01/22";
		String descricaoPrograma1 = "lupita expulsa do cologio";
		
		String cana2 = "Globo";
		String NomePrograma2 = "fantastico";
		String horarioPrograma2 = "21:00";
		String dataPrograma2 = "28/01/22";
		String descricaoPrograma2 = "Noticias da semana ";
		
		String cana3 = "Telecine Premium";
		String NomePrograma3 = "todo mundo e panico";
		String horarioPrograma3 = "21:00";
		String dataPrograma3 = "28/01/22";
		String descricaoPrograma3 = "Filmes de comedia ";
		
		ControleDados d = new ControleDados();
		ControleProgramas controleProgramas = new ControleProgramas(d);
		assertEquals(2,controleProgramas.cadastrarPrograma(canal,NomePrograma1, horarioPrograma1,dataPrograma1,descricaoPrograma1));
		assertEquals(2,controleProgramas.cadastrarPrograma(cana2,NomePrograma2, horarioPrograma2,dataPrograma2,descricaoPrograma2));
		assertEquals(3,controleProgramas.cadastrarPrograma(cana3,NomePrograma3, horarioPrograma3,dataPrograma3,descricaoPrograma3));
	}
}