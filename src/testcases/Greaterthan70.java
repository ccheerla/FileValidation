package testcases;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import reusableMethods.BaseClass;
import reusableMethods.FilesComparisonClass;

public class Greaterthan70 {
	@Test
	public void result() throws IOException {
		BaseClass baseClass = new BaseClass();
		File file1 =    new File(baseClass.getSourcePath());
		File file2 =    new File(baseClass.getTargetPath());
		File file3 = new File(baseClass.getResultPath());
		System.out.println("Verifying if both work books have same number of rows and columns");
		FilesComparisonClass fcc = new FilesComparisonClass();
		fcc.datacomp(file1,file2,file3);
	}
	
	
}
