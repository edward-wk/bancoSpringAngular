package com.banco.repository;

import com.banco.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  Usuario findUsuarioByEmailAndPass(String email, String pass);
}
