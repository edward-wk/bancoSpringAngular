package com.banco.controller;

import com.banco.model.Tipousuario;
import com.banco.service.TipoUsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipousuario/")
public class TipoUsuarioController {

  final TipoUsuarioService tipoUsuarioService;

  public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
    this.tipoUsuarioService = tipoUsuarioService;
  }

  @GetMapping("{id}")
  @ResponseBody
  public Tipousuario getById(@PathVariable Long id) {
    return tipoUsuarioService.getById(id);
  }

  //  @PatchMapping("update")
  //  public int updateDesc(@RequestBody Map<String, String> request) {

  //    Long id = Long.parseLong(request.get("id"));
  //    String newDesc = request.get("desc");

  //    return tipoUsuarioService.update(id, newDesc);
  //  }

  @DeleteMapping("delete/{id}")
  public int delete(@PathVariable Long id) {
    return tipoUsuarioService.deleteById(id);
  }
}
