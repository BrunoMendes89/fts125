package americanas;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IncluirCarrinho {	
	
	String url; 
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
	

	// Tirar Print da Tela
	public void Print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\bruno\\fts125-workspace\\Americanas\\target\\evidencias\\" + nomePasta + "\\" + nomePrint +".png"));
	}	
	
	@Given("^I access Americanas site$")
	public void i_access_Americanas_site() throws Throwable {
		url = "http://www.americanas.com.br";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\fts125-workspace\\Americanas\\drivers\\chrome\\79\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Print("Passo 1 - Acessou Americanas");
	}

	@When("^I type the term \"([^\"]*)\" and press Enter$")
	public void i_type_the_term_and_press_Enter(String term) throws Throwable {
		driver.findElement(By.id("h_search-input")).click();
		driver.findElement(By.id("h_search-input")).clear();
		driver.findElement(By.id("h_search-input")).sendKeys(Keys.chord(term));
		driver.findElement(By.id("h_search-input")).sendKeys(Keys.ENTER);
		Print("Passo 2 - Digitou o termo de busca e pressionou Enter");
	}

	@And("^I view the list of products and click in Agile Testing Foundations book$")
	public void i_view_the_list_of_products_and_click_in_Agile_Testing_Foundations_book() throws Throwable {
		Thread.sleep(3000);
		assertEquals("Agile Testing em Promoção nas Lojas Americanas.com",driver.getTitle());
		driver.findElement(By.cssSelector(".ImageUI-sc-9rtsvr-0")).click();
		Print("Passo 3 - Visualizou a lista de Produtos e clicou no livro Agile Testing Foundations");
	}

	@Then("^I click in \"([^\"]*)\" button$")
	public void i_click_in_button(String comprar) throws Throwable {
		driver.findElement(By.cssSelector(".iXIDWU")).click();
		Print("Passo 4 - Clicou no botao Comprar");
		driver.quit();
		
	}
	
}
