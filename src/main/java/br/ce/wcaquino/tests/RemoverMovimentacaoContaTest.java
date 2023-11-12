package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	MenuPage menuPage = new MenuPage();
	ContasPage contaPage = new ContasPage();
	
	@Test
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		contaPage.clicarExcluirConta("Thiago7");
		Assert.assertEquals("Conta em uso na movimentações", contaPage.obterMensagemErro());
	}
}
