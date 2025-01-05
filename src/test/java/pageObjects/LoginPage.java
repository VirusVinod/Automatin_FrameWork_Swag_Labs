package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import SwagLabs.Base;


public class LoginPage extends Base{

	public void user_enter_and(String uname, String pass) {
		
		WebElement username = driver.findElement(By.id("user-name"));
		CleanAndEnterText(username, uname);

		WebElement password = driver.findElement(By.id("password"));
		CleanAndEnterText(password, pass);
	}

	public void user_click_on_login_button() {
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();	

	}

	public void validate_user_logged_in_sucessfully() {
		WebElement tittle = driver.findElement(By.xpath("//span[@class='title']"));
		validateText(tittle, "Products");

	}
	
}
