package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis  = null ;
	public FileInputStream getFileInputStream() throws IOException
	{
		String filePath = System.getProperty(("user.dir")+"\\src\\test\\java\\data\\userdata.xlsx");
		File srcFile = new File(filePath);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("data file not found"+e.getMessage());
			System.exit(0);
		}
		return fis ;
	}
	public Object [][] getExcelData () throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);//kol file el excel
		XSSFSheet sheet = wb.getSheetAt(0);
		int TotalNumberofRows = (sheet.getLastRowNum()+1);
		int TotalNumberofCol = 4;
		String [][] arrofExcelData = new String[TotalNumberofRows][TotalNumberofCol];
		for (int i = 0; i < TotalNumberofRows; i++) {
			for (int j = 0; j <TotalNumberofCol; j++) {
				XSSFRow row  = sheet.getRow(i);
				arrofExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrofExcelData;
	}
}
