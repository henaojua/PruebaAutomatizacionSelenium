Feature: Finalizar compra como Guest Checkout

Scenario: Usuario invitado completa una compra exitosa
  Given que el usuario tiene productos en el carrito
  And navega a la página de checkout
  When selecciona "Checkout como Invitado"
  And completa el formulario de envío con información válida
  And selecciona el método de pago "Cash on Delivery"
  And confirma el pedido
  Then debe verse la página de confirmación con el mensaje "Your order has been placed!"
