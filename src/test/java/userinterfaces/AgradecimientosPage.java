package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AgradecimientosPage {


    public static final Target AREAPRODUCTO1 = Target.the("Area producto MDF 00015").located(By.cssSelector("div[data-product-id='4079']"));
    public static final Target AÑADIRALCARRITOPRO1 = Target.the("Añadir producto MDF 00015").located(By.cssSelector("a[aria-describedby='woocommerce_loop_add_to_cart_link_describedby_4079']"));
    public static final Target AREAPRODUCTO2 = Target.the("Area producto MDF 00029").located(By.cssSelector("div[data-product-id='4065']"));
    public static final Target AÑADIRALCARRITOPRO2 = Target.the("Añadir producto MDF 00029").located(By.cssSelector("a[aria-describedby='woocommerce_loop_add_to_cart_link_describedby_4065']"));
}
