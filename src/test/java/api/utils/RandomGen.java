package api.utils;

import java.util.Random;

public class RandomGen {

	private static final int LENGTH = 5;
	private static final int DecimalPlace = 2;
	public static final String DATA = "ABCDEFGHIJKLMNOabcdefghijklmno1234567890";
	public static final String DATA1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmno";
	public static final String DATA2 = "1234567890";
	public static final String DATA3 = "123456789";
	public static final String DATA4 = "!@#$%^&*()_+=-{}:\"|<>?/.,;\'[]\'";
	private static final String DATA5 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public static Random RANDOM = new Random();

	/**
	 * This method generates random numbers
	 */
	public  int getRandomNumber() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(DATA5.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	/**
	 * This method generates random string
	 */
	public  String getRandomString() {
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < LENGTH; i++) {
			int number = getRandomNumber();
			char ch = DATA5.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	/**
	 * Another method of generates random string
	 */

	public  String getRandomAlphabets() {
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
			sb.append(DATA1.charAt(RANDOM.nextInt(DATA1.length())));
		}

		return sb.toString();
	}

	/**
	 * This method generates random AlphaNumeric string
	 */
	public  String getRandomAlphaNumeric() {
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
			sb.append(DATA.charAt(RANDOM.nextInt(DATA.length())));
		}
		return sb.toString();
	}

	/**
	 * This method generates random numbers
	 */
	public  String getRandomNumeric() {
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
			sb.append(DATA2.charAt(RANDOM.nextInt(DATA2.length())));
		}
		return sb.toString();
	}

	/**
	 * This method generates random numbers Without Zero
	 */
	public  String getRandomNumberWithoutZero() {
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
			sb.append(DATA3.charAt(RANDOM.nextInt(DATA3.length())));
		}
		return sb.toString();
	}

	/**
	 * This method generates random Decimal Number
	 */
	public  String getRandomDecimalNumber() {
		StringBuilder sb = new StringBuilder(LENGTH + DecimalPlace + 1);
		for (int i = 0; i < LENGTH; i++) {
			sb.append(DATA2.charAt(RANDOM.nextInt(DATA2.length())));
		}
		sb.append(".");
		for (int i = 0; i < DecimalPlace; i++) {
			sb.append(DATA3.charAt(RANDOM.nextInt(DATA3.length())));
		}
		return sb.toString();
	}

	/**
	 * This method generates random Special Characters
	 */
	public  String getRandomSpecialCharacters() {
		StringBuilder sb = new StringBuilder(LENGTH);

		for (int i = 0; i < LENGTH; i++) {
			sb.append(DATA4.charAt(RANDOM.nextInt(DATA4.length())));
		}
		return sb.toString();

	}

	public static void main(String a[]) 
	{
		RandomGen msr=new RandomGen();
		System.out.println("Random Number: " + msr.getRandomNumber());
		System.out.println("Random String: " + msr.getRandomString());
		System.out.println("Random Alphabets: " + msr.getRandomAlphabets());
		System.out.println("Random AlphaNumeric: " + msr.getRandomAlphaNumeric());
		System.out.println("Random Numeric: " + msr.getRandomNumeric());
		System.out.println("Random Number Without Zero: " + msr.getRandomNumberWithoutZero());
		System.out.println("Random Decimal Numer: " + msr.getRandomDecimalNumber());
		System.out.println("Random Special Characters: " + msr.getRandomSpecialCharacters());


	}
}
