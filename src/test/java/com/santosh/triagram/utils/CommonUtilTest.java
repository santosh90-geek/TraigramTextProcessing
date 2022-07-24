package com.santosh.triagram.utils;

import static org.junit.Assert.assertEquals;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.santosh.triagram.fileoperation.FileOperation;

class CommonUtilTest {
	CommonUtil commonUtil = new CommonUtil();
	FileOperation fileOperation=new FileOperation();

	  @Test
	    void testSmallInputFile() {
	        File testFile = new File("src/test/sources/example.txt");
	        fileOperation.readFile(testFile);
	        List<String> expectedText = new ArrayList<String>();
	        expectedText.add("I wish I may I wish I might");
	        assertEquals(expectedText,fileOperation.getInputText());
	    }

}
