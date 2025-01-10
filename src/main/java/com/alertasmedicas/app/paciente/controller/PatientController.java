package com.alertasmedicas.app.paciente.controller;

import com.alertasmedicas.app.paciente.dto.PatientDTO;
import com.alertasmedicas.app.paciente.service.PatientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/getPatients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        log.info("Obteniendo todos los pacientes...");
        try {
            List<PatientDTO> patients = patientService.getAllPatientsAsDTO();
            log.info("Lista de pacientes obtenida exitosamente. Total: {} pacientes.", patients.size());
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            log.error("Error al obtener los pacientes", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getPatient/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable long id) {
        log.info("Obteniendo paciente con id: {}", id);
        try {
            PatientDTO dto = patientService.getPatientAsDTO(id);
            log.info("Paciente obtenido exitosamente: {}", dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al obtener el paciente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO) {
        log.info("Registrando el paciente...");
        try {
            log.info("Datos del paciente: {}", patientDTO);
            PatientDTO dto = patientService.savePatientAsDTO(patientDTO);
            log.info("Paciente registrado exitosamente: {}", dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al registrar el paciente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDTO) {
        log.info("Actualizando el paciente...");
        try {
            log.info("Datos a actualizar del paciente: {}", patientDTO);
            PatientDTO dto = patientService.updatePatientAsDTO(patientDTO);
            log.info("Paciente actualizado exitosamente: {}", dto);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            log.error("Error al actualizar el paciente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PatientDTO> deletePatient(@PathVariable long id) {
        log.info("Eliminando el paciente con id: {}", id);
        try {
            patientService.deletePatient(id);
            log.info("Paciente eliminado exitosamente");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error al eliminar el paciente: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
