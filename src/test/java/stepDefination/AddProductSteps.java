package stepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddProductPage;

public class AddProductSteps {
	
	AddProductPage tt =new AddProductPage();

	@When("user add a product")
	public void user_add_a_product() {
		tt.user_add_a_product();
	    
	}
	@Then("Validate item add to sucessfully")
	public void validate_item_add_to_sucessfully() {
	   tt.validate_item_add_to_sucessfully();
	}


}
