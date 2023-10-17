package com.banco.model.dto;

public record UsuarioDto(
    Integer id,
    Integer tipoUsuario,
    String dni,
    String nombre,
    String apellido1,
    String apellido2,
    String email,
    String telefono,
    String password) {}
