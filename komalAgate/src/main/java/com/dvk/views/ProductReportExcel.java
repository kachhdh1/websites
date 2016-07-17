package com.dvk.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.dvk.model.Product;

public class ProductReportExcel extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook wb,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// change the file name
		response.setHeader("Content-Disposition",
				"attachment; filename=\"Product-report.xlsx\"");

		@SuppressWarnings("unchecked")
		List<Product> allProducts = (List<Product>) model.get("allProduct");

		// create excel xls sheet
		Sheet sheet = wb.createSheet("Spring MVC AbstractXlsx");

		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Product");
		header.createCell(1).setCellValue("Category");
		header.createCell(2).setCellValue("Price");

		// Create data cells
		int rowCount = 1;
		for (Product product : allProducts) {
			Row courseRow = sheet.createRow(rowCount++);
			courseRow.createCell(0).setCellValue(product.getProductName());
			courseRow.createCell(1).setCellValue(product.getProductCategory());
			courseRow.createCell(2).setCellValue(product.getProductPrice());
		}
	}

}
