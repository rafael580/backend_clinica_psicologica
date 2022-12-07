package com.example.psicologia.repository.paciente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PacienteRepositoryImpl {


    @PersistenceContext
    private EntityManager manager;

}
