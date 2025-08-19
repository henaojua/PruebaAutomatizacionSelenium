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
            case "Agradecimientos":
                actor.attemptsTo(WaitUntil.the(MainPage.AGRADECIMIENTOS, isVisible()));
                actor.attemptsTo(
                        Click.on(MainPage.AGRADECIMIENTOS)
                );
            break;

            case "Anchetas":
                actor.attemptsTo(WaitUntil.the(MainPage.ANCHETAS, isVisible()));
                actor.attemptsTo(
                        Click.on(MainPage.ANCHETAS)
                );
                break;

            case "Carro": {
                actor.attemptsTo(WaitUntil.the(MainPage.CARRO, isVisible()));
                actor.attemptsTo(
                        Click.on(MainPage.CARRO)
                );
                break;
            }
        }

    }
}
