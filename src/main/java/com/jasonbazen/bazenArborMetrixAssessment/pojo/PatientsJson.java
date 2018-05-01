package com.jasonbazen.bazenArborMetrixAssessment.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientsJson implements Serializable {

    private List<PatientJson> patients = new ArrayList<PatientJson>();

    public List<PatientJson> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientJson> patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientsJson that = (PatientsJson) o;
        return Objects.equals(patients, that.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patients);
    }

    @Override
    public String toString() {
        return "PatientsJson{" +
                "patients=" + patients +
                '}';
    }

}
