package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.AgradecimientosPage;

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
            case "MDF 00015":
                actor.attemptsTo(WaitUntil.the(AgradecimientosPage.AREAPRODUCTO1, isVisible()));
                actor.attemptsTo(MoveMouse.to(AgradecimientosPage.AREAPRODUCTO1));


                actor.attemptsTo(WaitUntil.the(AgradecimientosPage.AÑADIRALCARRITOPRO1, isVisible()));
                actor.attemptsTo(Click.on(AgradecimientosPage.AÑADIRALCARRITOPRO1)
                );

                break;

            case "MDF 00029":
                actor.attemptsTo(WaitUntil.the(AgradecimientosPage.AREAPRODUCTO2, isVisible()));
                actor.attemptsTo(MoveMouse.to(AgradecimientosPage.AREAPRODUCTO2));

                actor.attemptsTo(WaitUntil.the(AgradecimientosPage.AÑADIRALCARRITOPRO2, WebElementStateMatchers.isCurrentlyEnabled()));
                actor.attemptsTo(Click.on(AgradecimientosPage.AÑADIRALCARRITOPRO2));

                break;



        }

    }

}
