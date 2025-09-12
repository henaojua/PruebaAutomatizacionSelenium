package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.MainPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SeleccionarProducto implements Task {

    private final String producto;

    public SeleccionarProducto(String producto){
        this.producto = producto;
    }

    public static SeleccionarProducto llamado(String producto){
        return Tasks.instrumented(SeleccionarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (this.producto){
            case "MacBook":
                actor.attemptsTo(WaitUntil.the(MainPage.MACBOOK, isVisible()));
                actor.attemptsTo(Click.on(MainPage.MACBOOK)
                );

                break;

            case "iPhone":
                actor.attemptsTo(WaitUntil.the(MainPage.IPHONE, isVisible()));
                actor.attemptsTo(Click.on(MainPage.IPHONE));

                break;
        }

    }

}
