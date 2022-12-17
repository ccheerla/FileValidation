package reusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class FilesComparisonClass {

	public void datacomp(File file1,File file2,File file3) throws IOException {
		
	
		//File file3 = new File(baseClass.getResultPath());
		FileInputStream fis1 = new FileInputStream(file1);
		FileInputStream fis2 = new FileInputStream(file2);
		FileInputStream fis3 = new FileInputStream(file3);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		XSSFWorkbook wb3 = new XSSFWorkbook(fis3);
			XSSFSheet s1 = wb1.getSheetAt(0);
			XSSFSheet s2 = wb2.getSheetAt(0);
			XSSFSheet s3 = wb3.getSheetAt(0);
			
			int rowsInSheet1 = s1.getPhysicalNumberOfRows();
			int rowsInSheet2 = s2.getPhysicalNumberOfRows();
			
		//	Assert.assertEquals(rowsInSheet1, rowsInSheet2, "Sheets have different count of rows..");
			System.out.println("No of rows in source::::::"+rowsInSheet1);
			System.out.println("No of rows in target::::::"+rowsInSheet2);
			System.out.println("No of Columns in source::::::"+s1.getRow(0).getLastCellNum());
			System.out.println("No of Columns in target::::::"+s2.getRow(0).getLastCellNum());
 
			Iterator<Row> rowInSheet1 = s1.rowIterator();
			Iterator<Row> rowInSheet2 = s2.rowIterator();
			int cellCounts1=0 ;
			int cellCounts2 =0;
			while (rowInSheet1.hasNext()) {
			 cellCounts1 = rowInSheet1.next().getPhysicalNumberOfCells();
			 cellCounts2 = rowInSheet2.next().getPhysicalNumberOfCells();
				
			//	Assert.assertEquals(cellCounts1, cellCounts2, "Sheets have different count of columns..");
		
		}
			//System.out.println(cellCounts1);
			//System.out.println(cellCounts2 );
			System.out.println("Verifying if both work books have same data.............");
			// Since we have already verified that both work books have same number of sheets so iteration can be done against any workbook sheet count
			int sheetCounts = wb1.getNumberOfSheets();
			List<Integer> arra = new ArrayList<Integer>();
			DataFormatter 	df = new DataFormatter();
			List<Integer> arra1 = new ArrayList<Integer>();
			// So we will iterate through sheet by sheet
			for (int i = 0; i < sheetCounts; i++) {
				// Get sheet at same index of both work books
				//System.out.println("*********** Sheet Name : "+s1.getSheetName()+"*************");
				// Iterating through each row
				int rowCounts = s1.getPhysicalNumberOfRows();
				
				for (int j = 0; j < rowCounts; j++) {
					// Iterating through each cell
					int cellCounts = s1.getRow(j).getPhysicalNumberOfCells();
					XSSFRow row = s3.createRow(j);
					
					for (int k = 0; k < cellCounts; k++) {
						// Getting individual cell
						Cell c1 = s1.getRow(j).getCell(k);
						Cell c2 = s2.getRow(j).getCell(k);
						
						Cell c3= row.createCell(k);
						//Cell c3= s3.getRow(j).createCell(l);
						// Since cell have types and need o use different methods
						if (c1.getCellType().equals(c2.getCellType())) {
							if (c1.getCellType() == CellType.STRING) {
								
								String v1 = c1.getStringCellValue();
								String v2 = c2.getStringCellValue();
								//Assert.assertEquals(v1, v2, "Cell values are different.....");
								
								if(v1.equals(v2)) {
									
									c3.setCellValue("Equal");
									//System.out.println("Its matched : "+ v1 + " === "+ v2);
									}else {
										c3.setCellValue("Not Equal");
									}
							}
							if (c1.getCellType() == CellType.NUMERIC) {
								// If cell type is numeric, we need to check if data is of Date type
								
								if (DateUtil.isCellDateFormatted(c1) | DateUtil.isCellDateFormatted(c2)) {
									// Need to use DataFormatter to get data in given style otherwise it will come as time stamp
								
									String v1 = df.formatCellValue(c1);
									String v2 = df.formatCellValue(c2);
									//Assert.assertEquals(v1, v2, "Cell values are different.....");
									if(v1.equals(v2)) {
										c3.setCellValue("Equal");
										//System.out.println("Its matched : "+ v1 + " === "+ v2);
										
										}else {
											c3.setCellValue("Not Equal");
										}
							
								}
							else {
									double v1 = c1.getNumericCellValue();
									double v2 = c2.getNumericCellValue();
									if(Double.compare(v1, v2) == 0) {
										c3.setCellValue("Equal");
										//System.out.println("Its matched : "+ v1 + " === "+ v2);
										}else {
											c3.setCellValue("Not Equal");
										}
								}
								
							
							}
							if (c1.getCellType() == CellType.BOOLEAN) {
								boolean v1 = c1.getBooleanCellValue();
								boolean v2 = c2.getBooleanCellValue();
								if(v1 == v2) {
									c3.setCellValue("Equal");
									//System.out.println("Its matched : "+ v1 + " === "+ v2);
									}else {
										c3.setCellValue("Not Equal");
									}
							}
						}
						 else
						{
							// If cell types are not same, exit comparison  
							//Assert.fail("Non matching cell type.");
							System.out.println("cell type are not matching");
						}
					}
				}

				int l=1;
				for( l=1;l<rowCounts;l++) {
					int intVar = Integer.parseInt(df.formatCellValue(s1.getRow(l).getCell(4)));
					if(intVar < 50) {
					arra.add(intVar); 
					
			}
					
					if(intVar > 70) {
					arra1.add(intVar); 
					
			}
				}
					int m=1;
					for( m=1;l<rowCounts;l++) {
						int intVarsheet2 = Integer.parseInt(df.formatCellValue(s2.getRow(l).getCell(4)));
						if(intVarsheet2 < 50) {
						arra.add(intVarsheet2); 
						
				}
						if(intVarsheet2 > 70) {
							arra1.add(intVarsheet2); 
							
					}
			}	
					System.out.println("[source file]values below 50 in Untis column are ::::::"+arra);
					System.out.println("[target file]values below 50 in Untis column are ::::::"+arra);
					System.out.println("[source file]values above 70 in Untis column are ::::::"+arra1);
					System.out.println("[target file]values above 70 in Untis column are ::::::"+arra1);
			System.out.println("Execution is done and Please check the result.xlss file to see the result of comparison");
			FileOutputStream outputStream = new FileOutputStream("C:/Users/0212A3744/eclipse-workspace/FileUploadAndDownload/dataFiles/result.xlsx");
			//XSSFWorkbook wb3 = null;
            wb3.write(outputStream);
		}
	
}
}



