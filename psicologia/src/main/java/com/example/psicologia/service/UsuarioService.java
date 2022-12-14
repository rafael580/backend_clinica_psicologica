package com.example.psicologia.service;

import com.example.psicologia.entity.Usuario;
import com.example.psicologia.repository.UsuarioRepository;
import com.example.psicologia.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario loginUsuario(String email){
        try{
            Usuario usuario = usuarioRepository.findBySenha(email);
            System.out.println(usuario);
            return usuario;
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found");
        }
    }

}
