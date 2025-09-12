package stepdefinitions;



import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.RealizarStep;
import tasks.SeleccionarOpcion;
import tasks.SeleccionarProducto;




public class Caso1 {
    @Managed
    WebDriver driver;


    private Actor usuario;

    @Before

    public void preparacionEscenario(){
        usuario = Actor.named("usuario");
        usuario.can(BrowseTheWeb.with(driver));
    }


    @Given("que el usuario tiene productos en el carrito")
    public void elUsuarioAgregaProductos(){
        usuario.attemptsTo(
                Open.url("https://opencart.abstracta.us/")
        );
        usuario.attemptsTo(SeleccionarProducto.llamado("MacBook"));
        usuario.attemptsTo(SeleccionarProducto.llamado("iPhone"));
    }

    @And("navega a la página de checkout")
    public void elUsuarioNavegaCheckout(){

        usuario.attemptsTo(SeleccionarOpcion.deseada("CarroCompras"));
        usuario.attemptsTo(SeleccionarOpcion.deseada("ConfirmarCompra"));
    }


    @When("selecciona \"Checkout como Invitado\"")
    public void elUsuarioRealizaCheckout(){
        usuario.attemptsTo(RealizarStep.indicado("Step 1"));

    }

    @And("completa el formulario de envío con información válida")
    public void elUsuarioLlenaFormulario(){
        usuario.attemptsTo(RealizarStep.indicado("Step 2"));
        usuario.attemptsTo(RealizarStep.indicado("Step 4"));
    }

    @And("selecciona el método de pago \"Cash on Delivery\"")
    public void elUsuarioSeleccionaMetodoPago(){
        usuario.attemptsTo(RealizarStep.indicado("Step 5"));
    }

    @And ("confirma el pedido")
    public void elUsuarioConfirmaPedido(){
        usuario.attemptsTo(RealizarStep.indicado("Step 6"));

    }

    @Then ("debe verse la página de confirmación con el mensaje \"Your order has been placed!\"")
    public void elUsuarioVeElMensaje(){
        usuario.attemptsTo(RealizarStep.indicado("Confirmacion"));

    }





}
