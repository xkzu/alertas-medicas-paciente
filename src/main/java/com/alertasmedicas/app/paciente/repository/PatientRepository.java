package com.alertasmedicas.app.paciente.repository;

import com.alertasmedicas.app.paciente.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
