package com.jake.pdf.createpdf.controllers;

import com.jake.pdf.createpdf.services.IGeneratePDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/pdf")
public class GeneratePDFController {

    @Autowired
    private IGeneratePDF generatePDF;

    @GetMapping("/createPdf")
    public ResponseEntity<InputStreamResource> createPDF(){
        ByteArrayInputStream pdf = generatePDF.generatePDF();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;file=lcwd.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

}
