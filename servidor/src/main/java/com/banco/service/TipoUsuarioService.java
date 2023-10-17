package com.banco.service;

import com.banco.model.Tipousuario;
import com.banco.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {

  final TipoUsuarioRepository tipoUsuarioRepository;

  public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
    this.tipoUsuarioRepository = tipoUsuarioRepository;
  }

  public Tipousuario save(Tipousuario tipousuario) {
    try {
      return tipoUsuarioRepository.save(tipousuario);
    } catch (Exception e) {
      return null;
    }
  }

  //
  //    public int update(Long id, String newDesc) {
  //        try {
  //            return tipoUsuarioRepository.updateDesc(id, newDesc);
  //        }catch (Exception e) {
  //            return -1;
  //        }
  //    }

  public int deleteById(Long id) {
    try {
      tipoUsuarioRepository.deleteById(id);
      return 0;
    } catch (Exception e) {
      return 1;
    }
  }

  public Tipousuario getById(Long id) {
    return tipoUsuarioRepository.findById(id).orElse(new Tipousuario());
  }
}
