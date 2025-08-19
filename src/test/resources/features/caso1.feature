Feature: Agregar productos

Scenario: Agregar dos productos al carrito de compras
  Given El usuario ingresa a la pagina
  When Se dirige a la opcion Agradecimientos
  And Agrega dos productos al carrito
  Then Se observa en la opcion Carro los productos agregados