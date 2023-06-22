package br.com.renato.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.renato.core.DriverFactory;

public class TestePaginaNttData {
	private WebDriver driver;

	
	@Before
	public void inicializa() {
		driver = DriverFactory.getDriver();

	}

	@Test
	public void testNavegarAtePaginaDaNttData() {
		//abrir tela do google
		driver.get("http://www.google.com");
		
		//maxima a janela do browser
		driver.manage().window().maximize();
		
		//Procura pelo elemento id
		WebElement search = driver.findElement(By.id("APjFqb"));
		
		//escreve na barra de endereço do google
		search.sendKeys(Keys.chord("ntt data"));
		
		//efetua a pesquisa
		search.submit();

		// efetua a busca do site da nttdata
		driver.findElement(By.xpath("//a[@href='https://www.nttdata.com/global/en/']")).click();
		// driver.findElement(By.cssSelector("a[href='https://www.nttdata.com/global/en/']")).click();

		//acessa o menu Careers
		WebElement element = driver.findElement(By.xpath("//span[text()=\"Careers\"]"));
		element.click();

		//acessa a opção Search Jobs
		driver.findElement(By.xpath("//a[@href=\"/global/en/careers/search-jobs?category=see-job\"]")).click();

		// efetua a busca do elemento id via xpath
		WebElement elementid = driver.findElement(By.xpath("//*[@id=\"search-jobs-query\"]"));
		
		// após a localização do id é efetuado o click na barra de pesquisa
		elementid.click();
		
		// escreve o valor dentro da barra de pesquisa
		elementid.sendKeys(Keys.chord("PESSOA ENGENHEIRA DE DADOS"));

		// efetua a pesquisa
		driver.findElement(By.id("search-jobs-submit")).click();

	}
	

	@After
	public void finaliza() {
		driver.quit();
	}
}
