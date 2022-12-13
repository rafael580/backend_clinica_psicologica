package com.example.psicologia.service;

import com.example.psicologia.dto.UsuarioDTO;
import com.example.psicologia.entity.Usuario;
import com.example.psicologia.repository.UsuarioRepository;
import com.example.psicologia.security.Token;
import com.example.psicologia.security.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    public UsuarioService(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    //METODO VALIDAÇÃO DE SENHA PARA LOGIN ById
    public Boolean validarSenha(Usuario user) {

        String senha = usuarioRepository.getById(user.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(user.getSenha(), senha);
        return valid;

    }


    public Token gerarToken(UsuarioDTO usuario) {

        Usuario user = usuarioRepository.findByNome(usuario.getNome());


        if(user != null) {

            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());

            if(valid) {

                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;

    }
}