package com.alertasmedicas.app.paciente.service;

import com.alertasmedicas.app.paciente.dto.PatientDTO;
import com.alertasmedicas.app.paciente.entity.Patient;
import com.alertasmedicas.app.paciente.mapper.PatientMapper;
import com.alertasmedicas.app.paciente.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDTO> getAllPatientsAsDTO() {
        return getAllPatients()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    @Override
    public PatientDTO getPatientAsDTO(Long id) {
        Patient patient = getPatientById(id);
        return PatientMapper.toDTO(patient);
    }

    @Override
    public PatientDTO savePatientAsDTO(PatientDTO patientDTO) {
        Patient patient = PatientMapper.toPatient(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(savedPatient);
    }

    @Override
    public PatientDTO updatePatientAsDTO(PatientDTO patientDTO) {
        Patient patient = PatientMapper.toPatient(patientDTO);
        Patient updatePatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatePatient);
    }

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

    private List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    private Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElse(new Patient());
    }

}
