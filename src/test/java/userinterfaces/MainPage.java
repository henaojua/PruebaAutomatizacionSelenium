package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class MainPage  {

    public static final Target MACBOOK = Target.the("Agregar MACBOOK").located(By.cssSelector("button[onclick=\"cart.add('43');\"]"));
    public static final Target IPHONE = Target.the("Agregar IPHONE").located(By.cssSelector("button[onclick=\"cart.add('40');\"]"));
    public static final Target CARRITOCOMPRAS = Target.the("Opcion Carro").located(By.cssSelector("#cart button[data-toggle=\"dropdown\"]"));
    public static final Target CHECKOUTCARRITO = Target.the("Opcion Carro").located(By.cssSelector("i.fa.fa-share + span.hidden-xs.hidden-sm.hidden-md"));

}
