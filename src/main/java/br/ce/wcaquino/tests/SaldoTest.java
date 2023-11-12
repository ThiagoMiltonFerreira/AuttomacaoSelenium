package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;
import br.ce.wcaquino.pages.MenuPage;

public class SaldoTest extends BaseTest {
    //Testes da tela home
	HomePage homePage  = new HomePage();
	MenuPage menuPage = new MenuPage();
	@Test
	public void validarSaldo() {
		menuPage.acessarTelaHome();
		Assert.assertEquals("Thiago72500.00", homePage.obterConta("Thiago7", "2500.00"));
		
	}
	
}
