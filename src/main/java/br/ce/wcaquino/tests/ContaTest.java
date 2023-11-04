package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();
	
	@Test
	public void testInserirConta(){
		
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
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contaPage.clicarAlterarConta("Thiago");
		contaPage.setNome("Thiago2");
		contaPage.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", contaPage.obterMensagemSucesso());		
	}
	@Test
	public void InserirContaMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contaPage.setNome("Thiago2");
		contaPage.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", contaPage.obterMensagemErro());
	}
}
