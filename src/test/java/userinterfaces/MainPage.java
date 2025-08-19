package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class MainPage  {

    public static final Target AGRADECIMIENTOS = Target.the("Opcion Agradecimientos").located(By.cssSelector("#menu-item-2794 a"));
    public static final Target ANCHETAS = Target.the("Opcion Agradecimientos").located(By.cssSelector("a:contains('Anchetas')"));
    public static final Target CARRO = Target.the("Opcion Carro").located(By.cssSelector("a.dropdown-toggle.mini-cart"));

}
