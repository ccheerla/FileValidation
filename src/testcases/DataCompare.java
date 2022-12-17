package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
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
import org.testng.annotations.Test;

import reusableMethods.BaseClass;
import reusableMethods.FilesComparisonClass;



public class DataCompare {

	@Test
	public void result() throws IOException {
		
		BaseClass baseClass = new BaseClass();
		File sourceFile =    new File(baseClass.getSourcePath());
		File targetFile =    new File(baseClass.getTargetPath());
		File resultFile = new File(baseClass.getResultPath());
		System.out.println("Verifying if both work books have same number of rows and columns");
		FilesComparisonClass fcc = new FilesComparisonClass();
		fcc.datacomp(sourceFile,targetFile,resultFile);
	}
	
	
}
