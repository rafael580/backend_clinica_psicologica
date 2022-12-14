package com.example.psicologia.repository;

import com.example.psicologia.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByNome(String nome);

}
