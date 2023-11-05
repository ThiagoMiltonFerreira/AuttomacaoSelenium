package br.ce.wcaquino.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;

public class HomePage extends BasePage {
	// Manipulação com a tela home

	public String obterConta(String conta, String saldo) {
		String contaFormatada = conta + saldo;
		contaFormatada = contaFormatada.replaceAll(" ", "");

		List<WebElement> resultados = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id='tabelaSaldo']/tbody/tr"));
		
		for (WebElement resultado : resultados) {
			if (resultado.getText().replaceAll(" ", "").equals(contaFormatada)) {
				//Assert.assertEquals(contaFormatada, resultado.getText().replaceAll(" ", ""));
				 return resultado.getText();
			}
		}
		//Assert.assertTrue(contaEncontrada);
		return "Conta nao encontrada";
	}
}