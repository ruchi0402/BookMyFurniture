package base;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

// this class contains common constant static data.
public class CommonConstant {
	public static Workbook book;
	public static Sheet sheet;
	public static final long PAGE_LOAD_TIMEOUT = 20;
	public static final long IMPLICIT_WAIT = 20;
	public static final String getURL = "http://okmry52647dns.eastus.cloudapp.azure.com:8089/rest/api/product/all";
	public static final String postURL = "http://okmry52647dns.eastus.cloudapp.azure.com:8089/rest/api/product/";
	public static final String DB_URL = "jdbc:mysql://okmry52647dns.eastus.cloudapp.azure.com:3306/bmf-abhishek-jun19-dev";
	public static final String DB_USER = "sdetuser1";
	public static final String DB_PASSWORD = "Welcome123$";
}
