package base;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	static Sheet s;
	public static void ExcelConfig(String Location ,String SheetName)
	{
		try
		{
		FileInputStream I=new FileInputStream(Location);
		if(Location.endsWith("xls")==true)
		{
			HSSFWorkbook wb=new HSSFWorkbook(I);
		
			s=wb.getSheet(SheetName);
		}
		else if(Location.endsWith("xlsx")==true)
		{
			XSSFWorkbook wb=new XSSFWorkbook(I);
			
			s=wb.getSheet(SheetName);
		}
		else
		{
			System.out.println("Invalid Format");
		}
		}
		catch(Exception E)
		{
			System.out.println("Error while Reading File");
		}
	}

	public static String  Read(int R,int C)
	{
		String A=s.getRow(R).getCell(C).toString();
		if(A.endsWith(".0"))
				A=A.split("\\.")[0];
		
		return A;
	}
	
	public static int  ROWNUM()
	{
		return s.getLastRowNum();
}

}
