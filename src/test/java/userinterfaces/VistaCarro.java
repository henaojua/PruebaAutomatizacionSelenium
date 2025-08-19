package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VistaCarro {
    public static final Target PRODUCTO1 = Target.the("Area producto MDF 00015").located(By.xpath("(//a[@class='product-name'])[3]"));
    public static final Target PRODUCTO2 = Target.the("Area producto MDF 00029").located(By.xpath("(//a[@class='product-name'])[4]"));



}