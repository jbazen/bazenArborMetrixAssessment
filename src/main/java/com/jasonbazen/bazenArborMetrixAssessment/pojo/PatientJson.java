package com.jasonbazen.bazenArborMetrixAssessment.pojo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "patientId", "sex", "state", "name", "age" })
public class PatientJson implements Serializable {

    private String patientId;

    private String sex;

    private String state;

    private String name;

    private String age;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientJson that = (PatientJson) o;
        return Objects.equals(patientId, that.patientId) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(name, that.name) &&
                Objects.equals(state, that.state) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, sex, name, state, age);
    }

    @Override
    public String toString() {
        return "PatientXml{" +
                "patientId='" + patientId + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}
