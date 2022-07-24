package com.santosh.triagram.generator;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;



class TriagramGeneratorTest {

	 TriagramGenerator triagramGenerator = new TriagramGenerator();
	    MutatedTextGenerator mutatedTextGenerator = new MutatedTextGenerator();

	    @Test
	    void generatingTextFlatTrigram() {
	        List<String> input = Collections.singletonList("testing flat trigram");
	        triagramGenerator.parseData(input);
	        mutatedTextGenerator.setTextLength(3);
	        mutatedTextGenerator.generateText(triagramGenerator.getTrigram());
	        String expectedGeneratedText = "testing flat trigram";
	        assertEquals(expectedGeneratedText,mutatedTextGenerator.getResultingText());

	    }

}
