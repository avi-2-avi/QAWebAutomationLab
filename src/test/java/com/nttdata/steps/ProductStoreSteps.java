package com.nttdata.steps;

import com.nttdata.page.CartPage;
import com.nttdata.page.InventoryPage;
import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductStoreSteps {
    private WebDriver driver;

    //constructor
    public ProductStoreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToLogin() {
        this.driver.findElement(InventoryPage.loginButton).click();
    }

    public void navigateToCategory(String category){
        // if category is man, click on that
        if (category.equals("Man")) {
            this.driver.findElement(InventoryPage.categoryMan).click();
        }
    }

    public void navigateToSubcategory(String subcategory){
        if (subcategory.equals("Clothes")) {
            this.driver.findElement(InventoryPage.subcategoryClothes).click();
        }
    }

    public void selectFirstProduct() {
        this.driver.findElement(InventoryPage.productThumbnail).click();
    }
    public void addProductToCart(int units) {
        for (int i = 0; i < units - 1; i++) {
            this.driver.findElement(ProductPage.addProductButton).click();
        }
        this.driver.findElement(ProductPage.addToCartButton).click();
    }

    public String getProductConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPage.productConfirmationPopup));
        return confirmationPopup.getText();
    }

    public String getTotalAmountPopup() {
        return this.driver.findElement(ProductPage.totalAmountPopup).getText();
    }

    public void finishPurchase() {
        this.driver.findElement(ProductPage.endShoppingButton).click();
    }

    public String getCartTitle() {
        return this.driver.findElement(CartPage.cartPageTitle).getText();
    }

    public String getTotalAmountCart() {
        return this.driver.findElement(CartPage.totalAmountCart).getText();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.errorMessage));
        return errorMessage.getText();
    }

    public void typeSearch(String search) {
        this.driver.findElement(InventoryPage.searchInput).sendKeys(search);
    }

    public void search() {
        this.driver.findElement(InventoryPage.searchInput).submit();
    }

    public String getNotFoundMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notFoundMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPage.notFoundMessage));
        return notFoundMessage.getText();
    }
}
