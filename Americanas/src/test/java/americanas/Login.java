package americanas;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class Login {
	
	String url; 
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
	

	// Tirar Print da Tela
	public void Print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\bruno\\fts125-workspace\\Americanas\\target\\evidencias\\" + nomePasta + "\\" + nomePrint +".png"));
	}
		
	@Given("^I access americanas web site$")
	public void i_access_americanas_web_site() throws Throwable {
		url = "http://www.americanas.com.br";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\fts125-workspace\\Americanas\\drivers\\chrome\\79\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Print("Passo 1 - Acessou o site Americanas");
	}

	@When("^I mouse over in the \"([^\"]*)\"$")
	public void i_mouse_over_in_the(String faca_login) throws Throwable {
		 {
		      WebElement element = driver.findElement(By.tagName("body"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element, 0, 0).perform();
		    }	 
		Print("Passo 2 - Passou o mouse em faca seu login");
	}

	@And("^I click in the button \"([^\"]*)\"$")
	public void i_click_in_the_button(String Entrar) throws Throwable {
		driver.findElement(By.cssSelector(".usr-act-text")).click();
	    driver.findElement(By.id("h_usr-signin")).click();	
		System.out.println("Passo 3 - Clicou no botao entrar");
	}

	@And("^I click in label \"([^\"]*)\" and type e-mail$")
	public void i_click_in_label_and_type_e_mail(String e_mail) throws Throwable {
	    driver.findElement(By.id("email-input")).click();
	    driver.findElement(By.id("email-input")).sendKeys("osvaldoheitorpeixoto10@gmail.com");
		Print("Passo 4 - Digitou o email");

	}

	@And("^I click in label \"([^\"]*)\" and type senha$")
	public void i_click_in_label_and_type_senha(String senha) throws Throwable {
		driver.findElement(By.id("password-input")).click();
		driver.findElement(By.id("password-input")).sendKeys("Osvaldo10@");
		Print("Passo 5 - Digitou a senha");
		
	}
	
	@And("^click in \"([^\"]*)\"$")
	public void click_in(String continuar) throws Throwable {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(90000); //inclui esse thread sleep para poder clicar no captcha manualmente
		Print("Passo 6 - Clicou no botao Continuar");
	}
	@Then("^I have successfully login$")
	public void i_have_successfully_login() throws Throwable {
		assertTrue(driver.findElement(By.cssSelector(".usr-nick")).getText().contains("Osvaldo"));
		Print("Passo 7 - Verificou se fez login com sucesso");
		driver.quit();
	}

}
