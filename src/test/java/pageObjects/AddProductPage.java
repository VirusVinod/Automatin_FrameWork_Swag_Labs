package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import SwagLabs.Base;


public class AddProductPage extends Base {
	
	public void user_add_a_product() {
		
		String targetProduct  = "Sauce Labs Bolt T-Shirt";
		List<WebElement> productList  = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        for (WebElement product : productList) {
            String productName = product.findElement(By.xpath(".//div[@class='inventory_item_name ']")).getText();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", product);
            if (productName.equals(targetProduct)) {
                WebElement addToCartButton = product.findElement(By.xpath(".//button[contains(@class,'btn_inventory')]"));
                addToCartButton.click();
                System.out.println("Added to cart: " + productName);
                break;
            }

        }
	    
	}
	public void validate_item_add_to_sucessfully() {
		WebElement shoppingCartBadge = driver.findElement(By.xpath("//div[@class='shopping_cart_container']//a//span"));
		validateText(shoppingCartBadge, "1");
	   
	}


}
