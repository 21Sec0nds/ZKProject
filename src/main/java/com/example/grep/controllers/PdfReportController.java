package com.example.grep.controllers;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/api/pdf")
public class PdfReportController {

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf(@RequestParam String title,
                                              @RequestParam double minSalary,
                                              @RequestParam String condition) {
        try {
            String jrxmlFile = "C:\\Users\\alex.alyeksyeyenko\\Desktop\\git2\\src\\main\\resources\\web\\report.jrxml";
            InputStream inputStream = new FileInputStream(jrxmlFile);
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title", title);
            parameters.put("minSalary", minSalary);
            parameters.put("condition", condition);

            JRDataSource dataSource = new JREmptyDataSource();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfStream));
            exporter.exportReport();

            byte[] pdfBytes = pdfStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.inline().filename("report.pdf").build());
            return ResponseEntity.ok().headers(headers).body(pdfBytes);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
