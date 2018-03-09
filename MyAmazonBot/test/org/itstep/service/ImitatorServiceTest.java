package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.model.Account;
import org.itstep.service.AccountRandomizer;
import org.itstep.service.ImitatorService;
import org.itstep.service.Timer;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImitatorServiceTest {

	@Test
	public void testRegisterAmazonAccount() {
		Account acc = new Account(AccountRandomizer.rndLogin(), AccountRandomizer.rndEmail(), AccountRandomizer.rndPassword());
		ImitatorService serv = new ImitatorService();
		WebDriver driver = serv.registerAmazonAccount(acc);
		assertTrue("The test is failed!", driver.getPageSource().contains("Hello, " + acc.getLogin()));
		driver.quit();
	}

	@Test
	public void testAddItemToCart() {
		String asin = "B01M3PGZJJ";
		Account acc = new Account(AccountRandomizer.rndLogin(), AccountRandomizer.rndEmail(), AccountRandomizer.rndPassword());
		ImitatorService serv = new ImitatorService();
		WebDriver driver = serv.addItemToCart(serv.registerAmazonAccount(acc), asin);
		assertTrue("The test is failed!", driver.getPageSource().contains("Added to Cart"));
		driver.quit();
	}

}
