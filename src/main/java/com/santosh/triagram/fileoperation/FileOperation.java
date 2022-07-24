package com.santosh.triagram.fileoperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.santosh.triagram.utils.CommonUtil;
import com.santosh.triagram.utils.Constants;
import com.santosh.triagram.utils.Constants.Severity;

public class FileOperation {
	private final List<String> inputText;
	private List<String> availableFiles;

	public FileOperation() {

		this.inputText = new ArrayList<String>();
		this.availableFiles = new ArrayList<>();
	}

	public List<String> getFileList() {

		return this.availableFiles;
	}

	public List<String> getInputText() {

		return inputText;
	}

	public void readFolder(File directory) {
		if (directory.list() == null) {
			CommonUtil.printMessage(Severity.ERROR, "Please add some source files in the library directory");
			System.exit(0);
		}
		this.availableFiles = Arrays.asList(directory.list());
		CommonUtil.printMessage(Severity.INFO, "files retrived from the library:");
	}

	public void optionsPrinter(List<String> listedElements) {

		for (int i = 0; i < listedElements.size(); i++) {
			System.out.println("\t[" + String.valueOf(i) + "]: " + listedElements.get(i));
		}
	}

	public void writeToFile(String generatedText, String filename) {
		File destinationFile = new File(Constants.outputDataDirectory + "/" + filename);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile));
			writer.write(generatedText);
			writer.close();

		} catch (Exception exp) {
			CommonUtil.printMessage(Severity.ERROR, exp.getMessage());
			CommonUtil.printMessage(Severity.INFO, generatedText);
			System.exit(0);
		}
	}

	public void hasAccess(File file) {
		if (!file.exists() || !file.canRead()) {
			CommonUtil.printMessage(Severity.ERROR, "Please check access to folder/file !!");
			System.exit(0);
		}
	}

	public void readFile(File file) {
		hasAccess(file);
		try {
			FileInputStream fileStream = new FileInputStream(file);
			DataInputStream inputStream = new DataInputStream(fileStream);
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = bufferReader.readLine()) != null) {
				this.inputText.add(line);
			}
			fileStream.close();
			CommonUtil.printMessage(Severity.INFO, "File successfully read!!");
		} catch (Exception exp) {
			CommonUtil.printMessage(Severity.ERROR, "Error Ocuured while reading file!!");
			System.exit(0);

		}

	}

}
