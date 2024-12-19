package com.example.grep.controllers;

import com.example.grep.dto.DetalleGasto;
import com.example.grep.models.Presupuestos;
import com.example.grep.services.GastosService;
import com.example.grep.services.PresupuestosService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pdf")
public class PdfReportController {

    @Autowired
    private GastosService gastosService;

    @Autowired
    private PresupuestosService presupuestosService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf(@RequestParam String title,
                                              @RequestParam double minSalary,
                                              @RequestParam int Presupuesto) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/web/report.jrxml");
            if (inputStream == null) {
                throw new FileNotFoundException("JRXML file not found in resources");
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("title", title);
            parameters.put("minSalary", minSalary);
            parameters.put("Presupuesto", Presupuesto);

            Optional<Presupuestos> optionalPresupuesto = presupuestosService.getAllPresupuestos().stream()
                    .filter(p -> p.getIdPresupuesto() != null && p.getIdPresupuesto() == Presupuesto)
                    .findFirst();

            if (optionalPresupuesto.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(("No Presupuesto found with idFinalidad: " + Presupuesto).getBytes());
            }

            Presupuestos presupuesto = optionalPresupuesto.get();
            double targetImporte = presupuesto.getPresupuesto();
            int targetDepartamentoId = presupuesto.getIdDepartamento().getIdDepartamento();

            List<DetalleGasto> filteredGastos = gastosService.getAllGastos().stream()
                    .filter(gasto -> gasto.getImporte() == targetImporte &&
                            gasto.getDepartamento().getIdDepartamento() == targetDepartamentoId)
                    .map(gasto -> new DetalleGasto(
                            gasto.getIdGasto(),
                            String.valueOf(gasto.getDepartamento().getIdDepartamento()),
                            "",
                            String.valueOf(gasto.getMes()),
                            gasto.getAnio(),
                            gasto.getImporte(),
                            gasto.getDescripcion()))
                    .collect(Collectors.toList());




            if (filteredGastos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No matching Gastos found".getBytes());
            }

            JRDataSource dataSource = new JRBeanCollectionDataSource(filteredGastos);

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

        } catch (JRException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating report".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("JRXML file not found".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred".getBytes());
        }
    }
}
