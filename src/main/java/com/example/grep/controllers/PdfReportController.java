package com.example.grep.controllers;

import com.example.grep.dto.DetalleGastoDTO;
import com.example.grep.dto.PresupuestosDTO;
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
    public ResponseEntity<byte[]> generatePdf(@RequestParam int Presupuesto) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/web/report.jrxml");
            if (inputStream == null) {
                throw new FileNotFoundException("JRXML file not found in resources");
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("idPresupuesto", Presupuesto);
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
            parameters.put("anioPresupuesto", presupuesto.getAnio());
            parameters.put("NombreDepartamento", presupuesto.getIdDepartamento().getNombreDepartamento());
            parameters.put("NombreFinalidad", presupuesto.getIdFinalidad().getNombreFinalidad());
            parameters.put("Mes", gastosService.getGastos(presupuesto.getIdPresupuesto()).getMes());
            parameters.put("Importe", gastosService.getGastos(presupuesto.getIdPresupuesto()).getImporte());
            parameters.put("Description", gastosService.getGastos(presupuesto.getIdPresupuesto()).getDescripcion());



//----------------------------------------------Get data----------------------------------------------------------------
//          -------------------------------------------Gastos------------------------------------------
            List<DetalleGastoDTO> filteredGastos = gastosService.getAllGastos().stream()
                    .filter(gasto -> gasto.getImporte() == targetImporte &&
                            gasto.getDepartamento().getIdDepartamento() == targetDepartamentoId)
                    .map(gasto -> new DetalleGastoDTO(
                            gasto.getIdGasto(),
                            String.valueOf(gasto.getDepartamento().getIdDepartamento()),
                            gasto.getFinalidad().getNombreFinalidad(),
                            String.valueOf(gasto.getMes()),
                            gasto.getAnio(),
                            gasto.getImporte(),
                            gasto.getDescripcion()
                            ))
                    .collect(Collectors.toList());
//          --------------------------------------------Presupuestos-----------------------------------
            PresupuestosDTO presupuestogetall = presupuestosService.getAllPresupuestos().stream()
                    .filter(p -> p.getIdPresupuesto() == Presupuesto)
                    .map(p -> new PresupuestosDTO(
                            p.getIdPresupuesto(),
                            p.getAnio(),
                            p.getIdDepartamento().getIdDepartamento(),
                            p.getIdFinalidad().getIdFinalidad(),
                            p.getPresupuesto()))
                    .findFirst()
                    .orElse(null);
//------------------------------------------------------------If dont have gastos--------------------------------------------------
            if (filteredGastos.isEmpty()) {
                filteredGastos.add(new DetalleGastoDTO(0, null, null, null, 0, 0, null));
            }
//--------------------------------------------------------Export to pdf------------------------------------------------------------
            JRDataSource dataSource1 = new JRBeanCollectionDataSource(filteredGastos);
            JasperPrint jasperPrint;
            if (!filteredGastos.isEmpty()) {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(filteredGastos));
            } else {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
            }

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
//-------------------------------------------------------------debug--------------------------------------------------
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