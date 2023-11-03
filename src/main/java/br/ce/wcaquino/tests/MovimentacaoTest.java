package br.ce.wcaquino.tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacao = new MovimentacaoPage();
	
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		movimentacao.setDataMovimentacao("01/09/2023");
		movimentacao.setDataPagamento("01/10/2023");
		movimentacao.setDescricao("Movimentaçao teste");
		movimentacao.setInteressado("Interessado teste");
		movimentacao.setValor("500");
		movimentacao.setConta("Conta do combo");
		movimentacao.setStatusPago();
		movimentacao.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacao.ObterMensagemSucesso());
	}
	
	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaMovimentacao();
		movimentacao.salvar();
		List<String> erros = movimentacao.ObterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório","Data do pagamento é obrigatório","Descrição é obrigatório","Interessado é obrigatório","Valor é obrigatório")));
		Assert.assertEquals(6, erros.size());
	}

	@Test
	public void testInserirMovimentacaoFutura() {
//			Data de movimentação deve ser menor ou igual a data atual
				
			menuPage.acessarTelaMovimentacao();
			movimentacao.setDataMovimentacao(movimentacao.getdataFutura());
			movimentacao.setDataPagamento(movimentacao.getdataAtual());
			movimentacao.setDescricao("Movimentaçao teste");
			movimentacao.setInteressado("Interessado teste");
			movimentacao.setValor("500");
			movimentacao.setConta("Conta do combo");
			movimentacao.setStatusPago();
			movimentacao.salvar();
			
			List<String> erros = movimentacao.ObterErros();
			Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação deve ser menor ou igual à data atual")));			
			
			Assert.assertEquals(1, erros.size());

	}
}
