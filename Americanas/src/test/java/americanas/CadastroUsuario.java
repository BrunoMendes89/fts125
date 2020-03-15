package americanas;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CadastroUsuario {
	
	String url; 
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
	

	// Tirar Print da Tela
	public void Print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\bruno\\fts125-workspace\\Americanas\\target\\evidencias\\" + nomePasta + "\\" + nomePrint +".png"));
	}	
	
	@Given("^I access the Americanas site$")
	public void i_access_the_Americanas_site() throws Throwable {
		url = "http://www.americanas.com.br";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\fts125-workspace\\Americanas\\drivers\\chrome\\79\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Print("Passo 1 - Acessou Americanas");
	}

	@When("^I mouse over in \"([^\"]*)\"$")
	public void i_mouse_over_in(String cadastre) throws Throwable {
		WebElement element = driver.findElement(By.cssSelector(".aspect-ratio__RatioComponentWrapper-wvhgzb-0 > .LinkUI-sc-1soz7d4-0 .Image-sc-1m5klhe-0"));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Print("Passo 2 - Passou o Mouse");
	}
	@And("^I click in \"([^\"]*)\"$")
	public void i_click_in(String cliente_novo) throws Throwable {
		driver.findElement(By.cssSelector(".usr-act-text")).click();
		driver.findElement(By.linkText("Cliente novo? Cadastrar")).click();
		Print("Passo 3 - Clicou em Cadastrar");
	}

	@And("^I click in label \"([^\"]*)\" and type the e-mail$")
	public void i_click_in_label_and_type_the_e_mail(String e_mail) throws Throwable {
		driver.findElement(By.id("email-input")).click();
		driver.findElement(By.id("email-input")).sendKeys("osvaldoheitorpeixoto10@gmail.com");
		Print("Passo 4 - Digitou o e-mail");
	}

	@And("^I click in label \"([^\"]*)\" and type the senha$")
	public void i_click_in_label_and_type_the_senha(String senha) throws Throwable {
		driver.findElement(By.id("password-input")).click();
	    driver.findElement(By.id("password-input")).sendKeys("Osvaldo10@");
	    Print("Passo 5 - Digitou a senha");
	}

	@And("^I click in label \"([^\"]*)\" and type the cpf$")
	public void i_click_in_label_and_type_the_cpf(String cpf) throws Throwable {
		driver.findElement(By.id("cpf-input")).click();
		driver.findElement(By.id("cpf-input")).sendKeys("99732208708");
		Print("Passo 6 - Digitou o cpf");
	}

	@And("^I click in label \"([^\"]*)\" and type the nome e sobrenome$")
	public void i_click_in_label_and_type_the_nome_e_sobrenome(String nome_sobrenome) throws Throwable {
		driver.findElement(By.id("name-input")).click();
	    driver.findElement(By.id("name-input")).sendKeys("Osvaldo Heitor Peixoto");
	    Print("Passo 7 - Digitou nome e sobrenome");
	}

	@And("^I click in label \"([^\"]*)\" and type the data de nascimento$")
	public void i_click_in_label_and_type_the_data_de_nascimento(String data_nascimento) throws Throwable {
		driver.findElement(By.id("birthday-input")).click();
	    driver.findElement(By.id("birthday-input")).sendKeys("07/05/1994");
	    Print("Passo 8 - Digitou data de nascimento");
	}

	@And("^I click in checkbox \"([^\"]*)\"$")
	public void i_click_in_checkbox(String masculino) throws Throwable {
		driver.findElement(By.cssSelector(".radio:nth-child(2) > label")).click();
		Print("Passo 9 - Escolheu sexo masculino");
	}

	@And("^I click in label \"([^\"]*)\" and type the telefone$")
	public void i_click_in_label_and_type_the_telefone(String telefone) throws Throwable {
		driver.findElement(By.id("phone-input")).click();
	    driver.findElement(By.id("phone-input")).sendKeys("(11) 99898-7878");
	    Print("Passo 10 - Digitou o telefone");
	}

	@Then("^I click in button \"([^\"]*)\"$")
	public void i_click_in_button(String criar_cadastro) throws Throwable {
		driver.findElement(By.cssSelector(".btn")).click();
		Thread.sleep(90000); //inclui esse thread sleep para poder clicar no captcha manualmente
		Print("Passo 11 - Clicou no Botao Cadastrar");
	}

	@Then("^I have successfully registered$")
	public void i_have_successfully_registered() throws Throwable {
		assertTrue(driver.findElement(By.cssSelector(".usr-nick")).getText().contains("Osvaldo"));
		Print("Passo 12 - Verificou se cadastrou com sucesso");
		driver.quit();
	}


}
