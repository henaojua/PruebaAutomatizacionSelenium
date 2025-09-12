package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.MainPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SeleccionarOpcion implements Task {

    private final String opcion;

    public SeleccionarOpcion(String opcion){
        this.opcion = opcion;
    }

    public static SeleccionarOpcion deseada(String opcion){
        return Tasks.instrumented(SeleccionarOpcion.class, opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        switch (opcion){
            case "CarroCompras": {

                actor.attemptsTo(WaitUntil.the(MainPage.CARRITOCOMPRAS, isVisible()));
                actor.attemptsTo(Click.on(MainPage.CARRITOCOMPRAS)
                );
                break;
            }
            case "ConfirmarCompra": {
                actor.attemptsTo(WaitUntil.the(MainPage.CHECKOUTCARRITO, isVisible()));
                actor.attemptsTo(Click.on(MainPage.CHECKOUTCARRITO));
                break;
            }
        }

    }
}
