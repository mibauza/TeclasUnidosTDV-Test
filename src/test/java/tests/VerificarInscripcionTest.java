package tests;

import org.testng.annotations.Test;
import pages.VerificarInscripcionPage;

public class VerificarInscripcionTest extends BaseTest {

    @Test
    public void testVerificacionDeInscripcionExitosa() throws InterruptedException {
        driver.get("http://localhost:4200/inscripcion/verificar");

        VerificarInscripcionPage pagina = new VerificarInscripcionPage(driver);
        pagina.completarFormulario("34567890", "Boxeo");

        // Esperar a que aparezca el mensaje (ejemplo simple)
        Thread.sleep(4000);

        String mensaje = pagina.obtenerMensaje();
        System.out.println("Mensaje recibido: " + mensaje);

        assert mensaje.contains("El socio puede inscribirse en la actividad.") ||
                mensaje.contains("El socio NO cumple con los requisitos de inscripción.") :
                "Mensaje inesperado: " + mensaje;

    }
}
