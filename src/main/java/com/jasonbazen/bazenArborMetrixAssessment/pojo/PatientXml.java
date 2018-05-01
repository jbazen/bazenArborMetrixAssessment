package com.jasonbazen.bazenArborMetrixAssessment.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patient")
public class PatientXml implements Serializable {

    private String id;

    private String gender;

    private String name;

    private String state;

    private String dob;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientXml that = (PatientXml) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(name, that.name) &&
                Objects.equals(state, that.state) &&
                Objects.equals(dob, that.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, name, state, dob);
    }

    @Override
    public String toString() {
        return "PatientXml{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

}
