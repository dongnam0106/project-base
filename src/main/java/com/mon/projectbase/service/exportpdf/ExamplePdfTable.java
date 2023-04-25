package com.mon.projectbase.service.exportpdf;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class ExamplePdfTable extends PdfPTable {

    public ExamplePdfTable(int numColumns) {
        super(numColumns);
    }

    public void addFormattedCell(Object text, String additionalString) {
        this.addFormattedCell(text, additionalString, null);
    }

    public void addFormattedCell(Object text, String additionalString, Integer alignment) {
        PdfPCell cell = new PdfPCell();
        if (alignment != null) {
            cell.setHorizontalAlignment(alignment);
        }
        if (text == null) {
            cell.setPhrase(new Phrase("", PdfUtils.getFontJP()));
            super.addCell(cell);
            return;
        }
        if (text instanceof Long) {
            String formattedDate = "Test";
            cell.setPhrase(new Phrase(formattedDate, PdfUtils.getFontJP()));
            super.addCell(cell);
            return;
        }
        cell.setPhrase(new Phrase(text.toString() + additionalString, PdfUtils.getFontJP()));
        super.addCell(cell);
    }
}