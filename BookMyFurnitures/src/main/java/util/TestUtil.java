package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import base.CommonMethods;
import pages.AccountPage;
import base.CommonConstant;

/*This class is contains excel utility that reads data from excel sheet which gets fed to the test case using data provider. The excel 
is 2 dimensional object.*/

public class TestUtil extends CommonMethods {

	static Logger log = Logger.getLogger(TestUtil.class);

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "\\src\\main\\java\\testdata\\Datasheet.xls";

	public static String takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+ "/test-output/screenshots/" + System.currentTimeMillis() + ".png";
		File finalDestination=new File(destination);
		FileUtils.copyFile(scrFile,finalDestination);
		return destination;
					
	}

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		}
		try {
			CommonConstant.book = new HSSFWorkbook(file);
		} catch (IOException e) {
			log.error(e.getMessage());
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
