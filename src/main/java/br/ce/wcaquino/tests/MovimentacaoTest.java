package br.ce.wcaquino.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;


//Definir ordem de execução dos metodos por ordem alfabetica (NAME_ASCENDING)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacao = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		movimentacao.setDataMovimentacao(movimentacao.getdataAtual());
		movimentacao.setDataPagamento(movimentacao.getdataAtual());
		movimentacao.setDescricao("Movimentaçao teste");
		movimentacao.setInteressado("Interessado teste");
		movimentacao.setValor("2500.00");
		movimentacao.setConta("Thiago7");
		movimentacao.setStatusPago();
		movimentacao.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacao.ObterMensagemSucesso());
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaMovimentacao();
		movimentacao.salvar();
		List<String> erros = movimentacao.ObterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório","Data do pagamento é obrigatório","Descrição é obrigatório","Interessado é obrigatório","Valor é obrigatório")));
		Assert.assertEquals(6, erros.size());
	}

	@Test
	public void test3_InserirMovimentacaoFutura() {
//			Data de movimentação deve ser menor ou igual a data atual
				
			menuPage.acessarTelaMovimentacao();
			movimentacao.setDataMovimentacao(movimentacao.getdataFutura());
			movimentacao.setDataPagamento(movimentacao.getdataAtual());
			movimentacao.setDescricao("Movimentaçao Futura");
			movimentacao.setInteressado("Interessado teste");
			movimentacao.setValor("500");
			movimentacao.setConta("Thiago7");
			movimentacao.setStatusPago();
			movimentacao.salvar();
			
			List<String> erros = movimentacao.ObterErros();
			Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação deve ser menor ou igual à data atual")));			
			
			Assert.assertEquals(1, erros.size());

	}
}
