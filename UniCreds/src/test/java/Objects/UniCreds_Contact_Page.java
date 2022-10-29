
              ////////////// MOHAMMAD UMER BAIG  ////////////////
             //////////////      29-10-2021     //////////////////
             

package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UniCreds_Contact_Page {
	
	WebDriver driver;
	
	public UniCreds_Contact_Page(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By textbox_Name = By.name("fullname");

	By textbox_Email = By.name("email");
	
	By textbox_Phone = By.name("phone");
	
	By textbox_Message = By.name("message");
	
	By button_Submit = By.id("contactButton");
	
	public void setTextInName(String Name) {

		driver.findElement(textbox_Name).sendKeys(Name);
	}

	public void setTextInEmail(String Email) {

		driver.findElement(textbox_Email).sendKeys(Email);
	}
	
	public void setTextInPhone(String Phone) {

		driver.findElement(textbox_Phone).sendKeys(Phone);
	}
	
	public void setTextInMessage(String Message) {

		driver.findElement(textbox_Message).sendKeys(Message);
	}
	
	public void clickOnSubmit() {

		driver.findElement(button_Submit).click();

	}


}
