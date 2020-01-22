package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import base.BasePage;
import base.CommonConstant;

public class TestUtil extends BasePage {

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\sdetlabs\\Desktop\\Ruchita-SDET\\BookMyFurniture\\BookMyFurnitures\\src\\main\\java\\testdata\\Datasheet.xls";

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile,
				new File(currentDir + "/test-output/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			CommonConstant.book = new HSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CommonConstant.sheet = CommonConstant.book.getSheet(sheetName);
		Object[][] data = new Object[CommonConstant.sheet.getLastRowNum()][CommonConstant.sheet.getRow(0)
				.getLastCellNum()];
		for (int i = 0; i < CommonConstant.sheet.getLastRowNum(); i++) {
			for (int k = 0; k < CommonConstant.sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = CommonConstant.sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

}
