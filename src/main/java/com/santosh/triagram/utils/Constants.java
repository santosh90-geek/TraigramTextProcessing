package com.santosh.triagram.utils;

import java.io.File;

public class Constants {

	public static final File dataDirectory = new File("inputData");
	public static final File outputDataDirectory = new File("outputData");
	public static final File logDirectory = new File("log/processingLog.log");
	public static final Integer requiredLength = 0;
	public static final String resultingText = "Error";

	public enum Severity {
		INFO, DEBUG, ERROR, WARN

	}
}
