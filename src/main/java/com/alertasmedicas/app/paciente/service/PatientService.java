package com.alertasmedicas.app.paciente.service;

import com.alertasmedicas.app.paciente.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    List<PatientDTO> getAllPatientsAsDTO();

    PatientDTO getPatientAsDTO(Long id);

    PatientDTO savePatientAsDTO(PatientDTO patientDTO);

    PatientDTO updatePatientAsDTO(PatientDTO patientDTO);

    void deletePatient(long id);
}
