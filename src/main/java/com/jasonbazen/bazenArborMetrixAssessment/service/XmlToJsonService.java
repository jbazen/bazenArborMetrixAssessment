package com.jasonbazen.bazenArborMetrixAssessment.service;

import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsJson;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsXml;

import java.io.IOException;

public interface XmlToJsonService {

    PatientsJson convertXmlToJson(PatientsXml patientsXml);

}
