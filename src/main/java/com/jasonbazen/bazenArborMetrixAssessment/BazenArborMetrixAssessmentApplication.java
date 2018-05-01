package com.jasonbazen.bazenArborMetrixAssessment;

import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsJson;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsXml;
import com.jasonbazen.bazenArborMetrixAssessment.service.XmlToJsonService;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.bind.JAXB;
import java.io.File;

@SpringBootApplication
public class BazenArborMetrixAssessmentApplication {

    private static final String DEFAULT_FILE_PATH = "patients.xml";

    public static void main(String[] args) {
        SpringApplication.run(BazenArborMetrixAssessmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(XmlToJsonService xmlToJsonService) {

        return args -> {
            String filePath;
            File xmlFile = null;

            if (args == null || args.length == 0) {
                filePath = DEFAULT_FILE_PATH;
                xmlFile = new File(filePath);
            } else {
                filePath = args[0];
                xmlFile = new File(filePath);

                if (!xmlFile.exists()) {
                    xmlFile = new File(DEFAULT_FILE_PATH);
                }
            }

            PatientsXml patients = JAXB.unmarshal(xmlFile, PatientsXml.class);
            PatientsJson patientsJson = xmlToJsonService.convertXmlToJson(patients);
        };

    }

}
