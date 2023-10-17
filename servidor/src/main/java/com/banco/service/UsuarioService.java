package com.banco.service;

import com.banco.model.Usuario;
import com.banco.model.dto.UsuarioDto;
import com.banco.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  final UsuarioRepository usuarioRepository;

  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public void save(UsuarioDto usuariodto) {
    Usuario user =
        Usuario.builder()
            .dni(usuariodto.dni())
            .pass(usuariodto.password())
            .nombre(usuariodto.nombre())
            .apellido1(usuariodto.apellido1())
            .apellido2(usuariodto.apellido2())
            .email(usuariodto.email())
            .telefono(usuariodto.telefono())
            .tipoUsuario(usuariodto.tipoUsuario())
            .build();

    usuarioRepository.save(user);
  }

  public int update() {
    try {
      return 0;
    } catch (Exception e) {
      return -1;
    }
  }

  public int deleteById(int id) {
    try {
      usuarioRepository.deleteById(id);
      return 0;
    } catch (Exception e) {
      return 1;
    }
  }

  public Optional<Usuario> getById(int id) {
    return usuarioRepository.findById(id);
  }

  public List<Usuario> getAll() {
    return usuarioRepository.findAll();
  }
}
