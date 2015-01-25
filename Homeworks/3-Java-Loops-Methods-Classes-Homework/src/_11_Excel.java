//	This program depends on the external library
//	Apache POI, which you need to get from
//	https://mega.co.nz/#F!uZFSVJwB!vDOGQ3ho6p5fzRugzkhDyA
//	Note: This is not the whole library, just the parts this task needs.
//	Just put the files in the project's lib directory.

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _11_Excel {
	public static void main(String[] args){
		Locale.setDefault(Locale.ROOT);
//		Prepare an ordered map of strings to doubles
//		to hold all the office names and their sub-totals.
		TreeMap<String, Double> subTotals = new TreeMap<>();
		double grandTotal = 0;
		
//		Open the provided Excel file, stream the
//		content to a new workbook and then get the only sheet.
		try (FileInputStream fis = new FileInputStream(new File("Incomes-Report.xlsx"));			
				XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			Sheet sheet1 = wb.getSheetAt(0);
//			Set up a row iterator that can go through the sheet's rows.
//			Skip over the first row as it only has the column titles.
			Iterator<Row> rowIterator = sheet1.iterator();
			Row row = rowIterator.next();
			
//			Traverse the sheet's rows and aggregate the results
//			in the sub-totals map and the grand total.
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				String office = row.getCell(0).getStringCellValue();
				double income = row.getCell(5).getNumericCellValue();
				double subTotal = subTotals.containsKey(office) ? subTotals.get(office) : 0;				
				subTotals.put(office, subTotal + income);
				grandTotal += income;
			}
		}
		catch (IOException e) {
			System.err.println("IO Exception");
		}
		
//		Traverse the map and print the results.
		for (Map.Entry<String, Double> subTotal : subTotals.entrySet()) {
			System.out.printf("%s Total -> %.2f\n", subTotal.getKey(), subTotal.getValue());
		}
		System.out.printf("Grand Total -> %.2f", grandTotal);
	}
}