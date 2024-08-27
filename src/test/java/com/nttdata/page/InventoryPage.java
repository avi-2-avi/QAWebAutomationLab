package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {
    public static By loginButton = By.xpath("//div[@id='_desktop_user_info']//a");
    public static By subcategoryClothes = By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a");
    public static By categoryMan = By.xpath("/html/body/main/section/div/div/div[1]/div[1]/ul/li[2]/ul/li[1]/a");
    public static By productThumbnail = By.cssSelector(".thumbnail.product-thumbnail");
    public static By searchInput = By.xpath("//*[@id='search_widget']/form/input[2]");

    public static By notFoundMessage = By.id("product-search-no-matches");
}
