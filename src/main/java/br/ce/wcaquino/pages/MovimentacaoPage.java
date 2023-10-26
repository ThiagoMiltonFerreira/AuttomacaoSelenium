package br.ce.wcaquino.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;

public class MovimentacaoPage extends BasePage{

	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);		
	}
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);		
	}
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);		
	}
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);		
	}
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	public void setStatusPago() {
		clicarRadio("status_pago");
	}
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	public String ObterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	public List<String> ObterErros(){
		// O xpath vai retornar mais de um elemento armazenar em um tipo element do tipo webelement que vai ser armazenado em uma lista do tipo webelement
		List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		//Lista de string parar armazenar os textos
		List<String> retorno = new ArrayList<String>();
		//Para cada item da lista de erros atribui a erro
		for(WebElement erro:erros) {
			//Adiciona a lista retorno o erro
			retorno.add(erro.getText());
		}
		return retorno;
	}
	
}
