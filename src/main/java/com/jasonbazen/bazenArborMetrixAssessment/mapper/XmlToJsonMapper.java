package com.jasonbazen.bazenArborMetrixAssessment.mapper;

import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientJson;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientXml;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsJson;
import com.jasonbazen.bazenArborMetrixAssessment.pojo.PatientsXml;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class XmlToJsonMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(PatientsXml.class, PatientsJson.class)
                .byDefault()
                .register();

        factory.classMap(PatientXml.class, PatientJson.class)
                .field("id", "patientId")
                .field("gender", "sex")
                .customize(new CustomMapper<PatientXml,PatientJson>() {

                    @Override
                    public void mapAtoB(PatientXml a, PatientJson b, MappingContext mappingContext) {
                        LocalDate dob = new LocalDate(new Date(a.getDob()));
                        LocalDate now = new LocalDate();
                        Years age = Years.yearsBetween(dob, now);

                        b.setAge(String.valueOf(age.getYears()));
                    }

                })
                .byDefault()
                .register();
    }

}
