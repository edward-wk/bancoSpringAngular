package com.banco.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movimiento")
public class Movimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idmovimiento", nullable = false)
  private Integer id;

  @Column(name = "importe", nullable = false)
  private Integer importe;

  @Column(name = "concepto", length = 45)
  private String concepto;

  @Column(name = "idTarjeta")
  private Integer idTarjeta;

  @Column(name = "idCuenta")
  private Integer idCuenta;

  @Column(name = "createdAt")
  private Instant createdAt;

  @Column(name = "updatedAt")
  private Instant updatedAt;
}
