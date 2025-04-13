package com.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    private static final String TEST_DATA_FILE = "src/test/resources/SearchTestData.xlsx";

    public static Map<String, String> getSearchTestData() {
        Map<String, String> testData = new HashMap<>();
        
        try (FileInputStream file = new FileInputStream(TEST_DATA_FILE);
             Workbook workbook = new XSSFWorkbook(file)) {
            
            Sheet sheet = workbook.getSheetAt(0); // First sheet
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell testCaseCell = row.getCell(0);
                    Cell inputCell = row.getCell(1);
                    if (testCaseCell != null && inputCell != null) {
                        testData.put(
                            testCaseCell.getStringCellValue().trim(),
                            inputCell.getStringCellValue().trim()
                        );
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file", e);
        }
        return testData;
    }
}