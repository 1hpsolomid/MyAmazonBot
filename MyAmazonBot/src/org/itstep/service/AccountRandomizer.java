package org.itstep.service;

public class AccountRandomizer {
	
	public static String rndLogin() {
		String login = String.valueOf(getRandomNumber(100, 999)) + "bog" + String.valueOf(getRandomNumber(100, 999)) + "dan" + String.valueOf(getRandomNumber(100, 999));
		return login;
	}
	
	public static String rndEmail() {
		String email = String.valueOf(getRandomNumber(100000, 999999)) + "bog" + String.valueOf(getRandomNumber(100000, 999999)) + "dan" + "@" + getDomain();
		return email;
	}
	
	public static String rndPassword() {
		String password = "pswd" + getRandomNumber(100000, 999999);
		return password;
	}
	


	private static int getRandomNumber(int min, int max) {
		int rndNumber = min + (int)(Math.random() * (max - min) + 1);
		return rndNumber;
	}
	
	private static String getDomain() {
		int rndInt = ((int) (Math.random() * 5));
		switch (rndInt) {
		case 0:
			
			return "gmail.com";
		case 1:

			return "bigmir.net";
		case 2:

			return "ukr.net";
		case 3:

			return "mail.ua";
		case 4:

			return "inbox.com";
		default:
			return "hotmail.com";
		}
	}
}
