package com.alertasmedicas.app.paciente.dto;

public record PatientDTO(
        Long id,
        Long idDoctor,
        String name,
        String state
) {}
