package com.jake.pdf.createpdf.services.impl;

import com.jake.pdf.createpdf.services.IGeneratePDF;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class GeneratePDFService implements IGeneratePDF {

    private final Logger log = LoggerFactory.getLogger(GeneratePDFService.class);

    @Override
    public ByteArrayInputStream generatePDF() {

        log.info("Create PDF started...");
        String title = "Gastos de mi casa";
        String content = "Esta es solo una pruena para la generacion de PDF con OpenPDF";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document doc = new Document();

        PdfWriter.getInstance(doc, out);

        doc.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
        Paragraph titleParagraph = new Paragraph(title,font);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);

        doc.add(titleParagraph);
        Paragraph paragraphPara = new Paragraph(content);
        paragraphPara.add(new Chunk("Esto es solo una prueba"));
        doc.add(paragraphPara);

        doc.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

}
