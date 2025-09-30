package com.projects.report;


import com.projects.md.models.User;
import com.projects.repository.UserRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessReport {

    UserRepository userRepository = new UserRepository();

    public void processReport() throws JRException {

        List<User> users = userRepository.findAll();

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);

        InputStream jasperStream = ProcessReport.class
                .getClassLoader()
                .getResourceAsStream("reports/report.jrxml");

        if (jasperStream == null) {
            throw new RuntimeException("report.jrxml não encontrado no classpath!");
        } else {
            System.out.println("Arquivo JRXML encontrado!");
        }

        JasperDesign jasperDesign = JRXmlLoader.load(jasperStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        Map<String, Object> params = new HashMap<>();
        params.put("ReportTitle", "User Report");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "users.pdf");

        System.out.println("Relatório gerado com sucesso!");
    }
}
