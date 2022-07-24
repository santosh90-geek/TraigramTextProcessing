package com.santosh.triagram.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.santosh.triagram.utils.CommonUtil;
import com.santosh.triagram.utils.Constants;
import com.santosh.triagram.utils.Constants.Severity;

public class MutatedTextGenerator {
	
	private String resultingText;

	public MutatedTextGenerator() {

		
		this.resultingText = Constants.resultingText;

	}

	
	public String getResultingText() {

		return this.resultingText;
	}

	public void joinText(List<String> generatedList) {

		StringBuilder generatedText = new StringBuilder();
		for (String s : generatedList) {
			generatedText.append(s);
			generatedText.append(" ");
		}
		this.resultingText = generatedText.substring(0, generatedText.length() - 1);
	}

	public void generateText(Map<String, ArrayList<String>> trigram) {
		List<String> generatedList = new ArrayList<>();
		List<String> trigramKeys = new ArrayList<>(trigram.keySet());
		String startingWords = trigramKeys.get(CommonUtil.pickRandom(trigramKeys.size()));
		generatedList.add(CommonUtil.separate(startingWords).get(0));
		generatedList.add(CommonUtil.separate(startingWords).get(1));
		String key = startingWords;
		int lastPositionPointer = 1;
		while (trigram.containsKey(key)) {
			ArrayList<String> nextWordCandidates = trigram.get(key);
			String nextWord = nextWordCandidates.get(CommonUtil.pickRandom(nextWordCandidates.size()));
			if (nextWord.contains(".")) {
				nextWord += "\n";
			}
			generatedList.add(nextWord);
			lastPositionPointer += 1;
			key = CommonUtil.replaceSpecialChracter(generatedList.get(lastPositionPointer - 1)) + " "
					+ CommonUtil.replaceSpecialChracter(generatedList.get(lastPositionPointer));
		}

		joinText(generatedList);
		CommonUtil.printMessage(Severity.INFO, "Mutated text generated succesfully!!");
	}

}
