package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

//Definir ordem de execução dos metodos por ordem alfabetica (NAME_ASCENDING)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ResumoTest extends BaseTest{

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
		
	}
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumo();
		// Garantir que a lista da tabela da tela resumo esta vazia 
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());		
	}
}
