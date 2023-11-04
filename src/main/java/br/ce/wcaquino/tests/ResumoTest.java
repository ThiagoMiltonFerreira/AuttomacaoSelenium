package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;


public class ResumoTest extends BaseTest{

	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	private MovimentacaoTest movimentacaoTest= new MovimentacaoTest(); 
	
	@Test
	public void testExcluirMovimentacao() {
		movimentacaoTest.testInserirMovimentacao();
		
		menuPage.acessarTelaResumo();
		resumoPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
		
	}
	
}
