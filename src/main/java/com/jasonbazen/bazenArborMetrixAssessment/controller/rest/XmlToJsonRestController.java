package com.jasonbazen.bazenArborMetrixAssessment.controller.rest;

import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsJson;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsXml;
import com.jasonbazen.bazenArborMetrixAssessment.service.XmlToJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("xmlToJson")
public class XmlToJsonRestController {

    public XmlToJsonService xmlToJsonService;

    @Autowired
    public XmlToJsonRestController(XmlToJsonService xmlToJsonService) {
        this.xmlToJsonService = xmlToJsonService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE)
    public PatientsJson handleXMLPostRequest (@RequestBody PatientsXml patientsXml) {
        return xmlToJsonService.convertXmlToJson(patientsXml);
    }

}
