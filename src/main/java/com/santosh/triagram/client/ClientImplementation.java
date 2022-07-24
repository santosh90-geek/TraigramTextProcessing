package com.santosh.triagram.client;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.santosh.triagram.fileoperation.FileOperation;
import com.santosh.triagram.generator.MutatedTextGenerator;
import com.santosh.triagram.generator.TriagramGenerator;
import com.santosh.triagram.utils.CommonUtil;
import com.santosh.triagram.utils.Constants;
import com.santosh.triagram.utils.Constants.Severity;

public class ClientImplementation {
	private static final FileOperation fileOperation = new FileOperation();
	private static File inputFile;
	private static String inputFileName;
	private static Integer outputLength;
	private static TriagramGenerator triagramGenerator = new TriagramGenerator();
	private static MutatedTextGenerator mutatedTextGenerator = new MutatedTextGenerator();

	public static void main(String[] args) {
		try {

			fileOperation.readFolder(Constants.dataDirectory);
			List<String> availableFiles = fileOperation.getFileList();
			CommonUtil.printMessage(Severity.INFO, "the following files are available for input:");
			fileOperation.optionsPrinter(availableFiles);
			inputFileName = availableFiles.get(CommonUtil.userInput("Select File", 0, availableFiles.size() - 1));
			inputFile = new File(Constants.dataDirectory + "/" + inputFileName);
			outputLength = CommonUtil.userInput("Select a length (in words) for the output",
					Constants.minimumOutputLength, Constants.maximumOutputLength);

		} catch (Exception e) {

		}

		fileOperation.readFile(inputFile);
		triagramGenerator.parseData(fileOperation.getInputText());
		mutatedTextGenerator.setTextLength(outputLength);
		mutatedTextGenerator.generateText(triagramGenerator.getTrigram());
		LocalDate localDate = LocalDate.now(ZoneId.of("GMT+01:00"));
		fileOperation.writeToFile(mutatedTextGenerator.getResultingText(), inputFileName + "_" + localDate + ".txt");

	}

}
