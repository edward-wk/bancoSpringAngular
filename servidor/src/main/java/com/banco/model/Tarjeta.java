package com.banco.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarjeta")
public class Tarjeta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idtarjeta", nullable = false)
  private Integer id;

  @Column(name = "numero", nullable = false)
  private Integer numero;

  @Column(name = "idCuenta", nullable = false)
  private Integer idCuenta;

  @Column(name = "estado", nullable = false)
  private Integer estado;
}
