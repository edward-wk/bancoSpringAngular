package com.banco.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipousuario")
public class Tipousuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idTipoUsuario", nullable = false)
  private Integer id;

  @Column(name = "desc", nullable = false, length = 50)
  private String desc;
}
