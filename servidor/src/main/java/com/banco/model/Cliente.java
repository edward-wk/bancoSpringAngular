package com.banco.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idcliente", nullable = false)
  private Integer id;

  @Column(name = "idcuenta", nullable = false)
  private Integer idcuenta;

  @Column(name = "idusuario", nullable = false)
  private Integer idusuario;
}
