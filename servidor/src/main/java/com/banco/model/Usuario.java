package com.banco.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idusuario", nullable = false)
  private Integer id;

  @Column(name = "tipoUsuario", nullable = false)
  private Integer tipoUsuario;

  @Column(name = "dni", nullable = false, length = 45)
  private String dni;

  @Column(name = "nombre", nullable = false, length = 45)
  private String nombre;

  @Column(name = "apellido1", nullable = false, length = 45)
  private String apellido1;

  @Column(name = "apellido2", length = 45)
  private String apellido2;

  @Column(name = "email", nullable = false, length = 45)
  private String email;

  @Column(name = "telefono", nullable = false, length = 45)
  private String telefono;

  @Column(name = "pass", nullable = false, length = 45)
  private String pass;

  @Override
  public String toString() {
    return "Usuario{"
        + "id="
        + id
        + ", tipoUsuario="
        + tipoUsuario
        + ", dni='"
        + dni
        + '\''
        + ", nombre='"
        + nombre
        + '\''
        + ", apellido1='"
        + apellido1
        + '\''
        + ", apellido2='"
        + apellido2
        + '\''
        + ", email='"
        + email
        + '\''
        + ", telefono='"
        + telefono
        + '\''
        + ", pass='"
        + pass
        + '\''
        + '}';
  }
}
