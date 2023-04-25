package com.mon.projectbase.service.exportpdf;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;

import java.awt.*;

public class PdfUtils {
    public static final String FONT = "fonts/Yu Gothic Medium.otf";

    public static final Font TITLE_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 20, Font.BOLD);
    public static final Font FONT_JP = getFontJP(10, Font.NORMAL, Color.BLACK);

    public static Font getFontJP() {
        return getFontJP(10, Font.NORMAL, Color.BLACK);
    }

    public static Font getFontJP(float fontSize, int fontStyle, Color color) {
        return FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, fontSize, fontStyle);
    }

}