package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.CheckoutPage;
import userinterfaces.ConfirmacionPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;


public class RealizarStep implements Task {

    private final String accion;

    public RealizarStep(String accion){
        this.accion = accion;
    }

    public static RealizarStep indicado(String accion){
        return Tasks.instrumented(RealizarStep.class, accion);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        switch (accion){
            case "Step 1": {
                actor.attemptsTo(WaitUntil.the(CheckoutPage.GUESTCHECKOUT, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.GUESTCHECKOUT));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.CONTINUESTEP1, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.CONTINUESTEP1));
                break;
            }
            case "Step 2": {
                actor.attemptsTo(WaitUntil.the(CheckoutPage.FIRSTNAME, isVisible()));
                actor.attemptsTo(Enter.theValue("Juan").into(CheckoutPage.FIRSTNAME));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.LASTNAME, isVisible()));
                actor.attemptsTo(Enter.theValue("Henao").into(CheckoutPage.LASTNAME));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.EMAIL, isVisible()));
                actor.attemptsTo(Enter.theValue("henaoariza2@gmail.com").into(CheckoutPage.EMAIL));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.TELEPHONE, isVisible()));
                actor.attemptsTo(Enter.theValue("3004883452").into(CheckoutPage.TELEPHONE));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.COMPANY, isVisible()));
                actor.attemptsTo(Enter.theValue("Sofka").into(CheckoutPage.COMPANY));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.ADDRESS1, isVisible()));
                actor.attemptsTo(Enter.theValue("Cra 104 # 15 a 90").into(CheckoutPage.ADDRESS1));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.ADDRESS2, isVisible()));
                actor.attemptsTo(Enter.theValue("Cra 104 # 38 a 90").into(CheckoutPage.ADDRESS2));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.CITY, isVisible()));
                actor.attemptsTo(Enter.theValue("Bogotá").into(CheckoutPage.CITY));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.POSTCODE, isVisible()));
                actor.attemptsTo(Enter.theValue("110921").into(CheckoutPage.POSTCODE));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.COUNTRY, isVisible()));
                actor.attemptsTo(SelectFromOptions.byVisibleText("Colombia").from(CheckoutPage.COUNTRY));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.REGION, isVisible()));
                actor.attemptsTo(SelectFromOptions.byVisibleText("Bogota D.C.").from(CheckoutPage.REGION));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.CONTINUESTEP2, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.CONTINUESTEP2));
            }
            case "Step 4": {
                actor.attemptsTo(WaitUntil.the(CheckoutPage.FlATRATE, isVisible()));
                actor.should(
                        seeThat(Text.of(CheckoutPage.FlATRATE), containsString("Flat Shipping Rate - $5.00"))
                );
                actor.attemptsTo(WaitUntil.the(CheckoutPage.CONTINUESTEP4, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.CONTINUESTEP4));
                break;
            }

            case "Step 5": {
                actor.attemptsTo(WaitUntil.the(CheckoutPage.PAYMENTMETHOD, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.PAYMENTMETHOD));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.TERMSANDCONDITIONS, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.TERMSANDCONDITIONS));

                actor.attemptsTo(WaitUntil.the(CheckoutPage.CONTINUESTEP5, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.CONTINUESTEP5));
                break;
            }

            case "Step 6": {
                actor.attemptsTo(WaitUntil.the(CheckoutPage.VALIDARMACBOOK, isVisible()));
                actor.should(
                        seeThat(Text.of(CheckoutPage.VALIDARMACBOOK), containsString("MacBook"))
                );
                actor.attemptsTo(WaitUntil.the(CheckoutPage.CONFIRMORDER, isVisible()));
                actor.attemptsTo(Click.on(CheckoutPage.CONFIRMORDER));
                break;
            }

            case "Confirmacion": {
                actor.attemptsTo(WaitUntil.the(ConfirmacionPage.MENSAJECONFIRMACION, isVisible()));
                actor.should(
                        seeThat(Text.of(ConfirmacionPage.MENSAJECONFIRMACION), containsString("Checkout"))
                );
                actor.attemptsTo(WaitUntil.the(CheckoutPage.CONFIRMORDER, isVisible()));
                break;
            }
        }
    }


}
