package com.dvk.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.dvk.model.Product;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ProductsReportPdf extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		@SuppressWarnings("unchecked")
		//the model is the data that we have passed in from the controller
		List<Product> products = (List<Product>) model.get("allProducts");
		PdfPTable table = new PdfPTable(3);
		for(Product product : products){
			table.addCell(product.getProductName());
			table.addCell(product.getProductCategory());
			table.addCell(product.getProductPrice()+" Rs");
		}
		
		doc.add(table);
	}

}
