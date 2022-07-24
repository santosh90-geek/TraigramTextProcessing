package com.santosh.triagram.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.santosh.triagram.utils.Constants.Severity;

public class CommonUtil {
	private final static Random random = new Random(System.currentTimeMillis());

	public static void printMessage(Severity type, String message) {
		String messageForPrint = "[" + type + "] : " + message;
		System.out.println(message);
		LoggingUtil.logMessage(messageForPrint);
	}

	public static String replaceSpecialChracter(String value) {
		String regex = "[^a-zA-Z|,|.|;|:| |]";
		return value.replaceAll(regex, "").toLowerCase();
	}

	public static List<String> separate(String concatenatedKey) {
		return Arrays.asList(concatenatedKey.split(" "));
	}

	public static Integer userInput(String message, Integer min, Integer max) {
		Scanner inputObj = new Scanner(System.in);
		CommonUtil.printMessage(Severity.INFO,
				message + " between " + String.valueOf(min) + " and " + String.valueOf(max));

		String input = inputObj.nextLine();
		Integer choice = Integer.valueOf(input);
		choiceValidator(choice, min, max);
		return choice;
	}

	public static void choiceValidator(Integer choice, Integer min, Integer max) {

		if (choice < min || choice > max) {
			CommonUtil.printMessage(Severity.ERROR, "input is invalid");
			System.exit(0);
		}
	}

	public static Integer pickRandom(Integer max) {
		
		return random.nextInt(max);
	}

}
