package com.jasonbazen.bazenArborMetrixAssessment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jasonbazen.bazenArborMetrixAssessment.mapper.XmlToJsonMapper;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsJson;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

@Component
public class XmlToJsonServiceImpl implements XmlToJsonService {

    private static final Logger log = LoggerFactory.getLogger(XmlToJsonServiceImpl.class);

    private XmlToJsonMapper xmlToJsonMapper;

    private ObjectMapper objectMapper;

    @Autowired
    public XmlToJsonServiceImpl(XmlToJsonMapper xmlToJsonMapper, ObjectMapper objectMapper) {
        this.xmlToJsonMapper = xmlToJsonMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public PatientsJson convertXmlToJson(PatientsXml patientsXml) {
        PatientsJson patientsJson = xmlToJsonMapper.map(patientsXml, PatientsJson.class);
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(patientsXml, stringWriter);
        File outJsonFile = new File("patients.json");

        try {
            log.info("Incoming XML: " + stringWriter.toString());
            log.info("Outgoing JSON: " + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patientsJson));
            log.info("Writing output JSON to file: " + outJsonFile.getAbsolutePath());

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("patients.json"), patientsJson);
        } catch(IOException e) {
            log.error("Exception while trying to write JSON to output file.", e);
        }

        return patientsJson;
    }

}
