//package com.utilities;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReader {
//    private static final String TEST_DATA_FILE = "src/test/resources/SearchTestData.xlsx";
////    private static final String ADDRESS_DATA_FILE = "src/test/resources/Address.xlsx";
//    public static Map<String, String> getSearchTestData() {
//        Map<String, String> testData = new HashMap<>();
//        
//        try (FileInputStream file = new FileInputStream(TEST_DATA_FILE);
//             Workbook workbook = new XSSFWorkbook(file)) {
//            
//            Sheet sheet = workbook.getSheetAt(0); // First sheet
//            for (int i = 0; i <= sheet.getLastRowNum(); i++) { // Skip header
//                Row row = sheet.getRow(i);
//                if (row != null) {
//                    Cell testCaseCell = row.getCell(0);
//                    Cell inputCell = row.getCell(1);
//                    if (testCaseCell != null && inputCell != null) {
//                        testData.put(
//                            testCaseCell.getStringCellValue().trim(),
//                            inputCell.getStringCellValue().trim()
//                        );
//                    }
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading Excel file", e);
//        }
//        return testData;
//    }
//    
//    
//    public static List<Map<String, String>> getData(String filePath, String sheetName) throws IOException {
//        List<Map<String, String>> testData = new ArrayList<>();
//        FileInputStream file = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheet(sheetName);
//        Row headerRow = sheet.getRow(0);
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = headerRow.getLastCellNum();
//
//        for (int i = 1; i < rowCount; i++) {
//            Row row = sheet.getRow(i);
//            Map<String, String> dataMap = new HashMap<>();
//            for (int j = 0; j < colCount; j++) {
//                String key = headerRow.getCell(j).getStringCellValue();
//                Cell cell = row.getCell(j);
//                String value = "";
//                if (cell != null) {
//                    switch (cell.getCellType()) {
//                        case STRING:
//                            value = cell.getStringCellValue();
//                            break;
//                        case NUMERIC:
//                            value = String.valueOf((int) cell.getNumericCellValue());
//                            break;
//                        case BOOLEAN:
//                            value = String.valueOf(cell.getBooleanCellValue());
//                            break;
//                        default:
//                            value = "";
//                    }
//                }
//                dataMap.put(key, value);
//            }
//            testData.add(dataMap);
//        }
//
//        workbook.close();
//        file.close();
//        return testData;
//    }
//
//}

package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    // Centralized file paths
    private static final String SEARCH_TEST_DATA_FILE = "src/test/resources/SearchTestData.xlsx";
    private static final String ADDRESS_DATA_FILE = "src/test/resources/Address.xlsx";

    // Method to get search test data
    public static Map<String, String> getSearchTestData() {
        Map<String, String> testData = new HashMap<>();
        
        try (FileInputStream file = new FileInputStream(SEARCH_TEST_DATA_FILE);
             Workbook workbook = new XSSFWorkbook(file)) {
            
            Sheet sheet = workbook.getSheetAt(0); // First sheet
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
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
            throw new RuntimeException("Error reading Excel file: " + SEARCH_TEST_DATA_FILE, e);
        }
        return testData;
    }
    
    // Method to get address data
    public static List<Map<String, String>> getAddressData() {
        return getData(ADDRESS_DATA_FILE, "Sheet1");
    }

    // Generic method to read Excel data (kept private as it's an internal implementation)
    private static List<Map<String, String>> getData(String filePath, String sheetName) {
        List<Map<String, String>> testData = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + filePath);
            }
            
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new RuntimeException("Header row not found in sheet: " + sheetName);
            }
            
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = headerRow.getLastCellNum();

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                Map<String, String> dataMap = new HashMap<>();
                for (int j = 0; j < colCount; j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    Cell cell = row.getCell(j);
                    String value = "";
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                value = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                value = String.valueOf((int) cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                value = String.valueOf(cell.getBooleanCellValue());
                                break;
                            default:
                                value = "";
                        }
                    }
                    dataMap.put(key, value);
                }
                testData.add(dataMap);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + filePath, e);
        }
        return testData;
    }
}

