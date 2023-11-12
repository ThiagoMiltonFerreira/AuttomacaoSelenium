package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaHome(){
		clicarLink("Home");
	}
	public void acessarTelaInserirConta(){
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	public void acessarTelaListarConta(){
		clicarLink("Contas");
		clicarLink("Listar");
	}
	public void acessarTelaMovimentacao(){
		clicarLink("Criar Movimentação");
	}
	public void acessarTelaResumo(){
		clicarLink("Resumo Mensal");
	}
}
