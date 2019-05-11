package com.sandeep.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.sandeep.fileupload.model.Employee;

public class FileUpload {

	public static void main(String[] args)
	{
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
		   
		    
		    
		    for(Employee e :empList)
		    {
		    	System.out.println(e.toString());
		    }
			Iterator<Row> rowIterator = sheet.iterator();
			System.out.println("hello file end");
			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				
				//System.out.println("Row"+row.getFirstCellNum());
			//System.out.println(row.getLastCellNum());
				Iterator<Cell> cellIterator=row.cellIterator();
				
				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					//System.out.println(cell);
					/*switch (cell.getCellType()) 
					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t\t");
						break;
					}*/
				}
				
				System.out.println();
			}
			/*	Map<String, Object[]> data = new HashMap<String, Object[]>();
				data.put("7", new Object[] { 3d, "Sonya", "SALES", "123456789" });
				data.put("8", new Object[] { 4d, "Kris","SALES", "9876543210" });
				data.put("9", new Object[] { 5d, "Dave", "SALES", "2580125654" });
				
				
				Set<String> newRows = data.keySet();
				
			    int rownum = sheet.getLastRowNum(); 
			    //row=null;
				for (String key : newRows)
				{
				    row = sheet.createRow(rownum++);
					Object[] objArr = data.get(key);
					int cellnum = 0;
					for (Object obj : objArr) 
					{
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof String)
						{
							cell.setCellValue((String) obj);
							
						} 
						else if (obj instanceof Boolean)
						{
							cell.setCellValue((Boolean) obj);
						} 
						else if (obj instanceof Date)
						{
							cell.setCellValue((Date) obj);
							
						} 
						else if (obj instanceof Double) 
						{
							cell.setCellValue((Double) obj);
						}
					}
				}
				
				FileOutputStream os = new FileOutputStream(excel);
				workbook.write(os);
				System.out.println("Writing on XLSX file Finished ...");*/


			}
		else
			System.out.println("");

		} catch (Exception e) {
			System.out.println(e.getMessage());
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
