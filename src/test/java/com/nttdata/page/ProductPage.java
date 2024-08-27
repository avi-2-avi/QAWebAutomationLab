package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {
    public static By addProductButton = By.xpath("/html/body/main/section/div/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By addToCartButton = By.cssSelector(".btn.btn-primary.add-to-cart");
    public static By productConfirmationPopup = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/p[1]");
    public static By totalAmountPopup = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/p[4]/span[2]");
    public static By endShoppingButton = By.xpath("//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a");
}
