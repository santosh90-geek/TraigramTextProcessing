package com.santosh.triagram.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.ZoneId;

public class LoggingUtil {

	public static void logMessage(String message) {
		try {
			LocalDate localDate = LocalDate.now(ZoneId.of("GMT+01:00"));
			FileWriter fileWriter = new FileWriter(Constants.logDirectory, true);
			BufferedWriter br = new BufferedWriter(fileWriter);
			br.write("[" + localDate + "] " + message + "\n");

			br.close();
			fileWriter.close();
		} catch (Exception e) {
			System.out.println("[!!] error with processing log creation ");
		}

	}

}
