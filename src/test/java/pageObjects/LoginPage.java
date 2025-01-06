package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import SwagLabs.Base;

public class LoginPage extends Base {

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

	public void validate_login_error_massage() {
		WebElement Errormessage = driver.findElement(By.xpath("//div[@class='error-message-container error']//h3"));
		validateText(Errormessage, "Epic sadface: Username and password do not match any user in this service");
	}

	public void user_enter(String string) {
		WebElement username = driver.findElement(By.id("user-name"));
		CleanAndEnterText(username, "");

		WebElement password = driver.findElement(By.id("password"));
		CleanAndEnterText(password, "");

	}

	public void verify_the_login_error_message_for_blank_email_and_password_fields() {
		WebElement Errormessage = driver.findElement(By.xpath("//div[@class='error-message-container error']//h3"));
		validateText(Errormessage, "Epic sadface: Username is required");
	}

}
