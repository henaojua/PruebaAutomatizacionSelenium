package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

   //Step1
   public static final Target GUESTCHECKOUT = Target.the("Opcion Guest Checkout").located(By.cssSelector("input[value=\"guest\"]"));
   public static final Target CONTINUESTEP1 = Target.the("Opcion Continue step 1").located(By.cssSelector("#button-account"));

   //Step 2
   public static final Target FIRSTNAME = Target.the("Campo First Name").located(By.cssSelector("#input-payment-firstname"));
   public static final Target LASTNAME = Target.the("Campo Last Name").located(By.cssSelector("#input-payment-lastname"));
   public static final Target EMAIL = Target.the("Campo Email").located(By.cssSelector("#input-payment-email"));
   public static final Target TELEPHONE = Target.the("Campo Telephone").located(By.cssSelector("#input-payment-telephone"));
   public static final Target COMPANY = Target.the("Campo Company").located(By.cssSelector("#input-payment-company"));
   public static final Target ADDRESS1 = Target.the("Campo Address1").located(By.cssSelector("#input-payment-address-1"));
   public static final Target ADDRESS2 = Target.the("Campo Address2").located(By.cssSelector("#input-payment-address-2"));
   public static final Target CITY = Target.the("Campo City").located(By.cssSelector("#input-payment-city"));
   public static final Target POSTCODE = Target.the("Campo PostCode").located(By.cssSelector("#input-payment-postcode"));
   public static final Target COUNTRY = Target.the("Campo Country").located(By.cssSelector("#input-payment-country"));
   public static final Target REGION = Target.the("Campo Region").located(By.cssSelector("#input-payment-zone"));
   public static final Target CONTINUESTEP2 = Target.the("Opcion Continue step 2").located(By.cssSelector("#button-guest"));

   //Step 4
   public static final Target FlATRATE = Target.the("Opcion Flat Rate").located(By.cssSelector("#collapse-shipping-method > div > div.radio > label"));
   public static final Target CONTINUESTEP4 = Target.the("Opcion Continue step 4").located(By.cssSelector("#button-shipping-method"));

   //Step 5

   public static final Target PAYMENTMETHOD = Target.the("Opcion Payment Method").located(By.cssSelector("input[value=\"cod\"]"));
   public static final Target TERMSANDCONDITIONS = Target.the("Opcion Terms and Conditions").located(By.cssSelector("input[name=\"agree\"]"));
   public static final Target CONTINUESTEP5 = Target.the("Opcion Continue step 4").located(By.cssSelector("#button-payment-method"));

   //Step 6

   public static final Target VALIDARMACBOOK = Target.the("Validar MacBook").located(By.cssSelector("tr:nth-child(2) > td.text-left:nth-child(1)"));
   public static final Target CONFIRMORDER = Target.the("Opcion Confirm Order").located(By.cssSelector("#button-confirm"));
}
