package com.banco.controller;

import com.banco.middlewares.CargarDTO;
import com.banco.model.Usuario;
import com.banco.model.dto.UsuarioDto;
import com.banco.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/")
@AllArgsConstructor
public class UsuarioController {

  // Service injection
  final UsuarioService usuarioService;
  final CargarDTO cargarDTO = new CargarDTO();

  // Service injection

  @GetMapping("{id}")
  public ResponseEntity<UsuarioDto> getUsuarioDTO(@PathVariable Integer id) {
    return usuarioService
        .getById(id)
        .map(user -> ResponseEntity.ok().body(cargarDTO.userDTO(user)))
        .orElse(null);
  }

  @GetMapping("all")
  public List<UsuarioDto> getAllUsers() {
    List<Usuario> users = usuarioService.getAll();
    ArrayList<UsuarioDto> usersDto = new ArrayList<>();

    users.forEach(usuario -> usersDto.add(cargarDTO.userDTO(usuario)));

    return usersDto;
  }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }



}
