package com.mon.projectbase.service.exportpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ExamplePdf extends PdfGenerator<ExampleHeader> {

    protected long total = 0;

    public ExamplePdf(List<Map<String, Object>> tableData, List<String> titles) throws DocumentException {
        super(tableData, titles);
    }

    @Override
    public void writeTittle() throws DocumentException {

        Font font = PdfUtils.TITLE_FONT;

        Paragraph paragraph = new Paragraph();

        Chunk chunk = new Chunk("Demo Export PDF", font);
        paragraph.add(chunk);

        if (!this.titles.isEmpty()) {
            paragraph.add(Chunk.NEWLINE);
            for (String title : this.titles) {
                Chunk subTitle = new Chunk(title, PdfUtils.FONT_JP);
                paragraph.add(subTitle);
                paragraph.add(Chunk.NEWLINE);
            }
        }
        document.add(paragraph);
        Chunk glue = new Chunk(new VerticalPositionMark());
        Paragraph p = new Paragraph("Left");
        p.add(new Chunk(glue));
        p.add("Right");
        document.add(p);
    }

    @Override
    public ExampleHeader[] getHeaders() {
        return ExampleHeader.values();
    }

    @Override
    public boolean isSpecialColumn(ExampleHeader header, Map<String, Object> data) {
        return false;
    }

    @Override
    protected Rectangle getSize() {
//        return new RectangleReadOnly(1684.0F, 1191.0F);
        return PageSize.A4;
    }

    @Override
    protected void writeFooter() {
        DecimalFormat nf = new DecimalFormat("###,###,###");
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(new BaseColor(247, 202, 172));
        cell.setPadding(5);
        cell.setColspan(getHeaders().length - 1);
        cell.setPhrase(new Phrase("Total", PdfUtils.getFontJP()));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        pdfPTable.addCell(cell);
        pdfPTable.addFormattedCell(nf.format(total) + "", "", PdfPCell.ALIGN_RIGHT);
    }
}