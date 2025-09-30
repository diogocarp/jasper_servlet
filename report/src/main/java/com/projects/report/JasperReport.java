package com.projects.report;

public class JasperReport{

    static ProcessReport processReport = new ProcessReport();

    public void buildReport() {
        try {
            processReport.processReport();
        } catch (Exception e) {
            throw new RuntimeException("Erro interno: " + e);
        }
    }
}

