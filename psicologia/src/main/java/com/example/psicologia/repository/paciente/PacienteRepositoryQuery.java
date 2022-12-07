package com.example.psicologia.repository.paciente;

import com.example.psicologia.entity.Paciente;
import com.example.psicologia.repository.filter.PacienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteRepositoryQuery {

    public Page<Paciente> filtar(PacienteFilter lancamentoFilter, Pageable pageable);

}
