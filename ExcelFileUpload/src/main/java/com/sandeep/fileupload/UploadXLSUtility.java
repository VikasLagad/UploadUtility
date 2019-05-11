/*package com.sandeep.fileupload;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.sandeep.fileupload.model.Employee;

public class UploadXLSUtility
{
	public void readXLS(File file) {
		
	}
	
	public void writeXLS() {
		Employee emp =new Employee();
		boolean flag = false;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try
		{
		System.out.println("1........");
		File excel = new File("/home/vicky/Desktop/employee.xls");
		String fileName=excel.getName();
		System.out.println(getFileExtension(excel));
		String extension=getFileExtension(excel);
		
		if(".xls".equalsIgnoreCase(extension) ||  ".xsls".equalsIgnoreCase(extension) )
		{	
			System.out.println("check ..........");
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(excel));
		    HSSFSheet sheet = workbook.getSheetAt(0);
		    System.out.println(sheet.getLastRowNum());
		    for( int i=sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++ )
		    {
	             Row ro=sheet.getRow(i);
	             for( int j=ro.getFirstCellNum(); j<=ro.getLastCellNum(); j++)
	             {
	                 Cell ce = ro.getCell(j);
	                 
	               if(j==0)
	               {  
	            	   flag = true;
	            	   if(ce.getCellType()==ce.CELL_TYPE_NUMERIC)
	            	   emp.setId((int) (ce.getNumericCellValue()));
	            	   System.out.println("ID......."+ce.getNumericCellValue());
	               }
	               if(j==1)
	               {
	            	   if(ce.getCellType()==ce.CELL_TYPE_STRING)
	            	   emp.setName(ce.getStringCellValue());
	            	   System.out.println("Name: "+ce.getStringCellValue());
	               }
	               if(j==2)
	               {
	            	   if(ce.getCellType()==ce.CELL_TYPE_STRING)
            		   emp.setDepartment(ce.getStringCellValue());
            		   System.out.println("Department......."+ce.getStringCellValue());
	               } 
	               if(j==3){
	            	   if(ce.getCellType()==ce.CELL_TYPE_NUMERIC)
	            		   System.out.println("Phone.......");
		            	   String str = NumberToTextConverter.toText(ce.getNumericCellValue());
		            	   System.out.println("Phone........."+str);
		            	   emp.setPhone(str);
	               }  
	                          
	             }
	             if(flag)
	             {
	             empList.add(new Employee(emp.getId(), emp.getName(), emp.getDepartment(), emp.getPhone()));
	             flag=false;
	             }
	         }
		   
		    
		    
		   
	}
	
	public static String getFileExtension(File excel) {
	    String name = excel.getName();
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
	}
}
*/