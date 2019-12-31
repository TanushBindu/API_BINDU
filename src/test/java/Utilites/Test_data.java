package Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Test_data 
{
	public static ArrayList<String> get_name() throws IOException 
	{
		ArrayList<String> name = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:/Users/Chaithra/Desktop/Data1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) 
		{
			if (wb.getSheetName(i).equalsIgnoreCase("Postdata")) 
			{
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> cell = firstrow.cellIterator();	
				int k = 0;
				int col = 0;
				while (cell.hasNext()) 
				{
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("job")) 
					{
						col = k;
					}
					k++;	
				}
				while (row.hasNext())
				{
					Row r = row.next();
					try 
					{
						if (r.getCell(col).getStringCellValue().equals("Dev"))
						{
							Iterator<Cell> cv = r.cellIterator();
							while (cv.hasNext()) 
							{
								name.add(cv.next().getStringCellValue());
							}
						}
					} 
					catch (Exception e) 
					{
						
					}
				}
			}
		}
		return name;
	}
	public static void main(String[] args) throws IOException 
	{
		ArrayList<String> a = get_name();
		System.out.println(a);
	}
	/*public ArrayList<String> get_job() throws IOException 
	{
		ArrayList<String> job = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:/Users/Chaithra/Desktop/Data1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) 
		{
			if (wb.getSheetName(i).equalsIgnoreCase("postdata")) 
			{
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> cell = firstrow.cellIterator();	
				int k = 0;
				int col = 0;
				while (cell.hasNext()) 
				{
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("job")) 
					{
						col = k;
					}
					k++;	
				}
				while (row.hasNext())
				{
					Row r = row.next();
					try 
					{
						if (r.getCell(col).getStringCellValue().equals("job"))
						{
							Iterator<Cell> cv = r.cellIterator();
							while (cv.hasNext()) 
							{
								job.add(cv.next().getStringCellValue());
							}
						}
					} 
					catch (Exception e) 
					{
						
					}
				}
			}
		}
		return job;
	}*/
}