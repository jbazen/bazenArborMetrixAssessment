package com.jasonbazen.bazenArborMetrixAssessment.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patients")
public class PatientsXml implements Serializable {

    public PatientsXml() {}

    @XmlElement(name="patient")
    private List<PatientXml> patients = new ArrayList<PatientXml>();

    public List<PatientXml> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientXml> patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientsXml that = (PatientsXml) o;
        return Objects.equals(patients, that.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patients);
    }

    @Override
    public String toString() {
        return "PatientsXml{" +
                "patients=" + patients +
                '}';
    }

}
