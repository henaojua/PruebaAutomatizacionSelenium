package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ConfirmacionPage {
    public static final Target MENSAJECONFIRMACION = Target.the("Mensaje Confirmacion").located(By.cssSelector("#content > h1"));
}
