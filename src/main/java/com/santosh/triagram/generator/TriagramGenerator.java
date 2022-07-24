package com.santosh.triagram.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.santosh.triagram.utils.CommonUtil;
import com.santosh.triagram.utils.Constants.Severity;

public class TriagramGenerator {
	private final Map<String, ArrayList<String>> trigram = new HashMap<>();

	public Map<String, ArrayList<String>> getTrigram() {

		return trigram;
	}

	public void parseData(List<String> inputText) {
		if (inputText == null || inputText.size() == 0) {
			CommonUtil.printMessage(Severity.ERROR, "input is empty");
			System.exit(0);
		}
		for (int i = 0; i < inputText.size(); i++) {
			ArrayList<String> input = new ArrayList<>(
					Arrays.asList(CommonUtil.replaceSpecialChracter(inputText.get(i)).split(" ")));
			if (i < (inputText.size() - 1)) {
				List<String> nextLineSplitted = Arrays
						.asList(CommonUtil.replaceSpecialChracter(inputText.get(i + 1)).split(" ", 3));
				if (nextLineSplitted.size() > 1) {
					input.add(nextLineSplitted.get(0));
					input.add(nextLineSplitted.get(1));
				}

			}
			if (input.size() < 3) {
				continue;
			}

			generateTrigram(input);
		}

	}

	private void generateTrigram(ArrayList<String> input) {
		for (int i = 0; i < input.size() - 2; i++) {
			String trigramKey = CommonUtil.replaceSpecialChracter(input.get(i)) + " "
					+ CommonUtil.replaceSpecialChracter(input.get(i + 1));
			String trigramValue = input.get(i + 2);

			if (trigram.containsKey(trigramKey)) {
				trigram.get(trigramKey).add(trigramValue);
			} else {
				ArrayList<String> trigramValues = new ArrayList<>();
				trigramValues.add(trigramValue);
				trigram.put(trigramKey, trigramValues);
			}
		}
	}

}
