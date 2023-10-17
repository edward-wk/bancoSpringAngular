package com.banco.middlewares;

import com.banco.model.Usuario;
import com.banco.model.dto.UsuarioDto;

public class CargarDTO {

  public CargarDTO() {}

  public UsuarioDto userDTO(Usuario user) {
    if (user != null) {
      return new UsuarioDto(
          user.getId(),
          user.getTipoUsuario(),
          user.getDni(),
          user.getNombre(),
          user.getApellido1(),
          user.getApellido2(),
          user.getEmail(),
          user.getTelefono(),
          null);
    } else return null;
  }
}
