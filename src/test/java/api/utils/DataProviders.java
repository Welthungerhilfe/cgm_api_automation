package api.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAlldata() throws IOException {
		String path = System.getProperty("user.dir") + "/Resources/PetData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);

		int rowNum = xl.getRowCount("sheet1");
		int colNum = xl.getCellCount("sheet1", 1);

		String data[][] = new String[rowNum][colNum];

		for (int i = 2; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				data[i - 1][j] = xl.getCellData("sheet1", i, j);
			}
		}
		return data;
	}

	@DataProvider(name = "PetID")
	public Integer[] getPetIDs() throws IOException {
		String path = System.getProperty("user.dir") + "/Resources/PetData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		int rowNum = xl.getRowCount("sheet1");
		System.out.println("total row ::"+ rowNum);
		//int x=0;
		List<Integer> petIdList = new ArrayList<>();

		for (int i = 1; i <= rowNum; i++) {
			if(!StringUtils.isEmpty(xl.getCellData("sheet1", i, 0))) {
				petIdList.add(Integer.valueOf(xl.getCellData("sheet1", i, 0)));
				/*
				 * petIds[x]=Integer.valueOf(xl.getCellData("sheet1", i, 0)); x++;
				 */
			}
		}
		
		System.out.println("petIds List : "+petIdList);
		Integer[] petIds = petIdList.stream().toArray(Integer[]::new);
		return petIds;
	}
	
	@DataProvider(name = "PetName")
	public static String[] getPetNames() throws IOException {
		String path = System.getProperty("user.dir") + "/Resources/PetData.xlsx";
		ExcelUtility xl = new ExcelUtility(path);
		int rowNum = xl.getRowCount("sheet1");
		String data[] = new String[rowNum];

		for (int i = 1; i <= rowNum; i++) {
			data[i - 1] = xl.getCellData("sheet1", i, 1);
		}
		return data;
	}
	
	
//	 public static void main(String args[]) throws IOException 
//	 { 
//		 getPetIDs(); 
//	 }
	 
}
