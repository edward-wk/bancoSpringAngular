package com.banco.service;

import com.banco.model.Usuario;
import com.banco.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

  private final UsuarioRepository usuarioRepository;

  public Usuario checkLogin(String email, String password) {
    return usuarioRepository.findUsuarioByEmailAndPass(email, password);
  }
}
