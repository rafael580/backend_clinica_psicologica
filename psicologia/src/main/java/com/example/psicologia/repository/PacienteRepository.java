package com.example.psicologia.repository;

import com.example.psicologia.entity.Paciente;
import com.example.psicologia.repository.paciente.PacienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> , PacienteRepositoryQuery {
}
