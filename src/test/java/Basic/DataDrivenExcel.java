package Basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenExcel {

	public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException {
		File f = new File("C:\\Users\\NEVEDHA\\eclipse2-workspace\\SD003\\target\\excel.xlsx");
		
		FileInputStream is = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook(is);
		
		XSSFSheet s = w.getSheet("Sheet1");
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		
		WebElement ele =  driver.findElement(By.name("q"));
		ele.sendKeys(s.getRow(1).getCell(1).getStringCellValue());
		
		Thread.sleep(1000);
		driver.close();
		
		
		
		/*for(int i = 0; i<s.getPhysicalNumberOfRows(); i++) {
			XSSFRow r = s.getRow(i);
			
			for(int j=0; j<r.getPhysicalNumberOfCells(); j++) {
				XSSFCell c = r.getCell(j);
				System.out.println(c);*/
			}
		
	
}
