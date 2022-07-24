package com.santosh.triagram.fileoperation;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;



class FileOperationTest {
	FileOperation manager = new FileOperation();
    File inputDir = new File("src/test/sources");

    @Test
    void getFileList() {
        manager.readFolder(inputDir);
        List<String> actualList = manager.getFileList();
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("input1.txt");
        expectedList.add("example.txt");
        assertEquals(expectedList, actualList);
    }

}
