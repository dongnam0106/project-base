package com.mon.projectbase.service.exportpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

public abstract class PdfGenerator<T extends Header> {

    protected Document document;
    protected ExamplePdfTable pdfPTable;
    protected List<Map<String, Object>> tableData;
    protected static final BaseColor HEADER_FOOTER_COLOR = new BaseColor(247, 202, 172);

    protected List<String> titles;

    PdfGenerator(List<Map<String, Object>> tableData, List<String> titles) throws DocumentException {
        this.tableData = tableData;
        this.pdfPTable = new ExamplePdfTable(getHeaders().length);
        pdfPTable.setWidthPercentage(100f);
        pdfPTable.setWidths(getTableWidths());
        pdfPTable.setSpacingBefore(10);
        document = new Document(getSize());
        this.titles = titles;
    }

    public void writeTable() {
        for (Map<String, Object> data : tableData) {
            for (T header : getHeaders()) {
                if (this.isSpecialColumn(header, data)) {
                    continue;
                }
                pdfPTable.addFormattedCell(data.get(header.getObjectFieldName()), header.getAppendString());
            }
        }
    }


    public ByteArrayInputStream generatePdf() throws DocumentException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            writeTittle();

            writeTableHeader();
            writeTable();

            writeFooter();
            document.add(pdfPTable);
        } finally {
            document.close();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public abstract void writeTittle() throws DocumentException;

    private void writeTableHeader() {

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(HEADER_FOOTER_COLOR);
        cell.setPadding(5);

        for (Header ticketHeader : getHeaders()) {
            cell.setPhrase(new Phrase(ticketHeader.getJapaneseName(), PdfUtils.getFontJP()));
            pdfPTable.addCell(cell);
        }

    }

    protected abstract void writeFooter();

    public abstract T[] getHeaders();

    public abstract boolean isSpecialColumn(T header, Map<String, Object> data);

    private float[] getTableWidths() {
        final float[] tableWidths = new float[getHeaders().length];
        for (int i = 0; i < getHeaders().length; i++) {
            tableWidths[i] = getHeaders()[i].getWidth();
        }
        return tableWidths;
    }

    protected abstract Rectangle getSize();
}