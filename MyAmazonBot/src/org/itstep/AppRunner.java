package org.itstep;

import java.util.ArrayList;

import org.itstep.dao.AccountDAO;
import org.itstep.dao.GoodAddingDAO;
import org.itstep.dao.GoodDAO;
import org.itstep.model.Account;
import org.itstep.service.AccountRandomizer;
import org.itstep.service.ImitatorService;
import org.itstep.service.Timer;
import org.openqa.selenium.WebDriver;

public class AppRunner {

	public static void main(String[] args) {
		ImitatorService imService = new ImitatorService();
		AccountDAO accountDAO = new AccountDAO();
		GoodDAO goodDAO = new GoodDAO();
		GoodAddingDAO goodAddingDAO = new GoodAddingDAO();
		ArrayList<String> asins = goodDAO.get();
		
		Account acc1 = new Account(AccountRandomizer.rndLogin(), AccountRandomizer.rndEmail(), AccountRandomizer.rndPassword());
		WebDriver driver = imService.registerAmazonAccount(acc1);
		accountDAO.save(acc1);
		Timer.waitSeconds(10);
		for (int i = 0; i < asins.size(); i+=2) {
			imService.addItemToCart(driver, asins.get(i));
			goodAddingDAO.save(acc1, asins.get(i));
			
		}
		
		Timer.waitSeconds(10);
		driver.quit();
		
//		Account acc2 = new Account(AccountRandomizer.rndLogin(), AccountRandomizer.rndEmail(), AccountRandomizer.rndPassword());
//		driver = imService.registerAmazonAccount(acc2);
//		accountDAO.save(acc2);
//		Timer.waitSeconds(10);
//		driver = imService.addItemToWL(driver, "B072M7R5MM");
//		driver.quit();
//		Account acc = accountDAO.get(login);
//		imService.registerAmazonAccount(acc);
//		WebDriver driver = null;
//		Timer.waitSeconds(10);
//		driver = imService.addItemToWL(driver,"B071WZSM4C");

//		driver.quit();
	}

}
