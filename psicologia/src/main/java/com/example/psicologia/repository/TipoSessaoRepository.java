package com.example.psicologia.repository;

import com.example.psicologia.entity.TipoSessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSessaoRepository extends JpaRepository<TipoSessao,Long> {
}
