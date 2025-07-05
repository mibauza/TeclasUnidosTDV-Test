package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerificarInscripcionPage {
    private WebDriver driver;

    @FindBy(id = "dni")
    private WebElement dniInput;

    @FindBy(id = "actividad")
    private WebElement actividadInput;

    @FindBy(css = "button[type='submit']")
    private WebElement verificarButton;

    @FindBy(css = "div[style*='margin-top']")
    private WebElement mensajeRespuesta;

    public VerificarInscripcionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ingresarDni(String dni) {
        dniInput.clear();
        dniInput.sendKeys(dni);
    }

    public void ingresarActividad(String actividad) {
        actividadInput.clear();
        actividadInput.sendKeys(actividad);
    }

    public void clickVerificar() {
        verificarButton.click();
    }

    public String obtenerMensaje() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeElemento = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[style*='margin-top']"))
        );
        return mensajeElemento.getText();
    }


    public void completarFormulario(String dni, String actividad) {
        ingresarDni(dni);
        ingresarActividad(actividad);
        clickVerificar();
    }
}
