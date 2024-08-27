package com.nttdata.stepsdefinitions;

import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.ProductStoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreStepsDef {
    private WebDriver driver;

    private ProductStoreSteps productStoreSteps(WebDriver driver){
        return new ProductStoreSteps(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        productStoreSteps(driver).navigateToLogin();

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        productStoreSteps(driver).navigateToCategory(category);
        productStoreSteps(driver).navigateToSubcategory(subcategory);
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int units) {
        productStoreSteps(driver).selectFirstProduct();
        productStoreSteps(driver).addProductToCart(units);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        String productConfirmation = productStoreSteps(driver).getProductConfirmation();
        Assertions.assertEquals("Hay 2 artículos en su carrito.", productConfirmation);
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        String productAmount = productStoreSteps(driver).getTotalAmountPopup();
        Assertions.assertEquals("S/ 38.24", productAmount);
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        productStoreSteps(driver).finishPurchase();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String pageTitle = productStoreSteps(driver).getCartTitle();
        Assertions.assertEquals("carrito", pageTitle.toLowerCase());
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        String productAmount = productStoreSteps(driver).getTotalAmountCart();
        Assertions.assertEquals("S/ 38.24", productAmount);
        screenShot();
    }

    @Cuando("me logueo con mi usuario {string} y clave incorrecta {string}")
    public void meLogueoConMiUsuarioYClaveIncorrecta(String user, String password) {
        productStoreSteps(driver).navigateToLogin();

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @Entonces("aparecera un mensaje de error")
    public void apareceraUnMensajeDeError() {
        String errorMessage = productStoreSteps(driver).getErrorMessage();
        Assertions.assertEquals("Error de autenticación.", errorMessage);
        screenShot();
    }

    @Cuando("busco {string} en el buscador")
    public void buscoEnElBuscador(String search) {
        productStoreSteps(driver).typeSearch(search);
        productStoreSteps(driver).search();
    }

    @Entonces("aparecera un mensaje coincidencia no encontrada")
    public void apareceraUnMensajeCoincidenciaNoEncontrada() {
        String errorMessage = productStoreSteps(driver).getNotFoundMessage();
        Assertions.assertEquals("No se han encontrado coincidencias con tu búsqueda", errorMessage);
        screenShot();
    }
}
