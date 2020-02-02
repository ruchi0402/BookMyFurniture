package base;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

// this class contains common constant static data.
public class CommonConstant {
	public static Workbook book;
	public static Sheet sheet;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String getURL = "http://okmry52647dns.eastus.cloudapp.azure.com:8089/rest/api/product/all";
	public static String postURL = "http://okmry52647dns.eastus.cloudapp.azure.com:8089/rest/api/product/";
}
