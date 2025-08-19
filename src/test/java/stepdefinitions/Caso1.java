package stepdefinitions;



import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.SeleccionarOpcion;
import tasks.SeleccionarProducto;
import userinterfaces.MainPage;
import userinterfaces.VistaCarro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;



public class Caso1 {
    @Managed
    WebDriver driver;


    private Actor usuario;

    @Before

    public void preparacionEscenario(){
        usuario = Actor.named("usuario");
        usuario.can(BrowseTheWeb.with(driver));
    }


    @Given("El usuario ingresa a la pagina")
    public void elUsuarioIngresa(){
        usuario.attemptsTo(
                Open.url("https://www.floristeriamundoflor.com/")
        );
    }

    @When("Se dirige a la opcion Agradecimientos")
    public void elUsuarioNavegaAgradecimientos(){

        usuario.attemptsTo(SeleccionarOpcion.deseada("Agradecimientos"));
    }

    @And("Agrega dos productos al carrito")
    public void elUsuarioAgregaProducto(){

        usuario.attemptsTo(SeleccionarProducto.llamado("MDF 00015"));
        usuario.attemptsTo(SeleccionarProducto.llamado("MDF 00029"));



    }


    @Then("Se observa en la opcion Carro los productos agregados")
    public void elUsuarioValidaLosProductos(){
        usuario.attemptsTo(SeleccionarOpcion.deseada("Carro"));
        usuario.attemptsTo(WaitUntil.the(VistaCarro.PRODUCTO1, isVisible()));
        usuario.should(seeThat("producto MDF 00015", Text.of(VistaCarro.PRODUCTO1), equalTo("MDF 00015")));
        usuario.attemptsTo(WaitUntil.the(VistaCarro.PRODUCTO2, isVisible()));
        usuario.should(seeThat("producto MDF 00029", Text.of(VistaCarro.PRODUCTO2), equalTo("MDF 00029")));
    }





}
