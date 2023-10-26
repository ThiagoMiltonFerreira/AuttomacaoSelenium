package br.ce.wcaquino.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;

public class ContasPage extends BasePage {
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	public void setNome() {
	        Random random = new Random();
	        int numeroAleatorio = random.nextInt(1000);
			escrever("nome", "Teste"+numeroAleatorio);
	}
	
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public void apagarTodasContas() {
		List<WebElement> resultados = DriverFactory.getDriver().findElements(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
		int quantidadeDeResultados = resultados.size();
		System.out.println(quantidadeDeResultados);
	
		for (int cont = 0; cont<quantidadeDeResultados;cont++) {
			clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));		
		}
	}

	public void clicarAlterarConta(String string) {
		
		obterCelula("Conta", string, "Ações","tabelaContas").findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();
		
		
		
	}
	
}
