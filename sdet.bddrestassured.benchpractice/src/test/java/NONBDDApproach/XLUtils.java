package NONBDDApproach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
		public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		return rowcount;
	}
	
	public static int getcolumncount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		int colcount = row.getLastCellNum();
		return colcount;
	}
	
	public static String getcelldata(String xlfile,String xlsheet,int rownum,int columnnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		XSSFCell s = row.getCell(columnnum);
		String celldata = s.toString();
		
		fi.close();
		return celldata;
	}
	
	public static void setcelldata(String xlfile,String xlsheet,int rownum,int columnnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(columnnum);
		 cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
	}
		

}
