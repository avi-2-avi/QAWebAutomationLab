#language: es
@testfeature
Característica: Product - Store

  @productStore
  Escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "avicon95@proton.me" y clave "Achilles2024!"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito

    @productStore
    Escenario: Usuario o contraseña incorrectos
      Dado estoy en la página de la tienda
      Cuando me logueo con mi usuario "avicon95@proton.me" y clave incorrecta "NoEsMiClave"
      Entonces aparecera un mensaje de error

    @productStore
    Escenario: Busqueda de categoria inexistentes
      Dado estoy en la página de la tienda
      Cuando busco "Autos" en el buscador
      Entonces aparecera un mensaje coincidencia no encontrada
