package net.anviprojects.SpringMVCProject.mvc.excelpdf;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 *  Представление для excel документов
 */
public class ExcelDocument extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// новая книга
		Sheet excelSheet = workbook.createSheet("Simple excel example");

		response.setHeader("Content-Disposition", "attachment; filename=excelDocumnent.xls");

		// работаем со шрифтом
		Font font = workbook.createFont();
		font.setFontName("Arial");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);

		// создаем стиль для заголовка
		CellStyle styleHeader = workbook.createCellStyle();
		styleHeader.setFillForegroundColor(HSSFColor.BLUE.index);
		styleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styleHeader.setFont(font);

		//задаем заголовок
		setExcelHeader(excelSheet, styleHeader);

		// получаем данные из модели
		List<Cat> cats = (List<Cat>) model.get("modelObject");
		int rowCount = 1;
		for (Cat cat : cats){
			Row row = excelSheet.createRow(rowCount++);
			row.createCell(0).setCellValue(cat.getName());
			row.createCell(1).setCellValue(cat.getColor());
			row.createCell(2).setCellValue(cat.getWeight());
		}
	}

	private void setExcelHeader(Sheet excelSheet, CellStyle styleHeader) {
		Row header = excelSheet.createRow(0);
		header.createCell(0).setCellValue("Name");
		header.getCell(0).setCellStyle(styleHeader);
		header.createCell(1).setCellValue("Color");
		header.getCell(1).setCellStyle(styleHeader);
		header.createCell(2).setCellValue("Weight");
		header.getCell(2).setCellStyle(styleHeader);
	}
}
