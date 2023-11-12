package br.ce.wcaquino.suits;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.tests.ContaTest;
import br.ce.wcaquino.tests.MovimentacaoTest;
import br.ce.wcaquino.tests.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.tests.ResumoTest;
import br.ce.wcaquino.tests.SaldoTest;

//Suite com todos os testes
@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	SaldoTest.class,
	RemoverMovimentacaoContaTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static MenuPage menu = new MenuPage();
	private static LoginPage page = new LoginPage();
	private static ContasPage conta = new ContasPage();
	
	// Antes de executar as classes roda esse metodo
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		page.setEmail("thiagomilton.f@f.com");
		page.setSenha("30081996");
		page.entrar();
	}
	
	//Depois de executar as classes roda esse metodo
	@AfterClass
	public static void finaliza() {
		menu.acessarTelaListarConta();
		conta.clicarExcluirConta("Thiago7");
		DriverFactory.killDriver();
	}
}
