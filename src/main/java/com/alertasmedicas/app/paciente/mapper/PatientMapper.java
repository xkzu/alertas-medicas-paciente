package com.alertasmedicas.app.paciente.mapper;

import com.alertasmedicas.app.paciente.dto.PatientDTO;
import com.alertasmedicas.app.paciente.entity.Patient;

public class PatientMapper {

    private PatientMapper() {}

    public static PatientDTO toDTO(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getIdDoctor(),
                patient.getName(),
                patient.getState()
        );
    }

    public static Patient toPatient(PatientDTO dto) {
        return new Patient(
                dto.id(),
                dto.idDoctor(),
                dto.name(),
                dto.state()
        );
    }
}
