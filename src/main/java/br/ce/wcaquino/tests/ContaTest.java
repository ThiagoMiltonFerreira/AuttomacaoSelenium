package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

//Definir ordem de execução dos metodos por ordem alfabetica (NAME_ASCENDING)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();
	
	@Test
	public void test1_InserirConta(){
		
		menuPage.acessarTelaInserirConta();
		contaPage.setNome("Thiago");
		contaPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obterMensagemSucesso());
		/*
		for (int i = 0; i < 10; i++) {
			menuPage.acessarTelaInserirConta();
			contaPage.setNome();
			contaPage.salvar();
			Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obterMensagemSucesso());
		}
		//contaPage.apagarTodasContas();
		 
		 */
	}
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contaPage.clicarAlterarConta("Thiago");
		contaPage.setNome("Thiago7");
		contaPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contaPage.obterMensagemSucesso());		
	}
	@Test
	public void test3_InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contaPage.setNome("Thiago7");
		contaPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contaPage.obterMensagemErro());
	}

}
