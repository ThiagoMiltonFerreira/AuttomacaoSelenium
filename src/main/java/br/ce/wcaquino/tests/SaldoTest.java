package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;

public class SaldoTest extends BaseTest {
    //Testes da tela home
	HomePage homePage  = new HomePage();
	@Test
	public void validarSaldo() {
		Assert.assertEquals("Conta do combo 2500.00", homePage.obterConta("Conta do combo", "2500.00"));
		
	}
	
}
