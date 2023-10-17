package com.banco.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cuenta")
public class Cuenta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idcuenta", nullable = false)
  private Integer id;

  @Column(name = "cuenta", nullable = false)
  private Integer cuenta;

  @Column(name = "estado")
  private Integer estado;
}
