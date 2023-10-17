package com.banco.repository;

import com.banco.model.Tipousuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<Tipousuario, Long> {

  //    @Transactional
  //    @Modifying
  //    @Query("update Tipousuario t set t.desc = :newDesc where t.idTipoUsuario = :id")
  //    int updateDesc(@Param(value ="id") long id, @Param(value ="newDesc") String newDesc);

}
