package com.banco.controller;

import com.banco.middlewares.CargarDTO;
import com.banco.model.Usuario;
import com.banco.model.dto.UsuarioDto;
import com.banco.service.AuthService;
import com.banco.service.UsuarioService;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/auth/")
public class AuthController {

    final UsuarioService usuarioService;
    final AuthService authService;
    final CargarDTO cargarDTO = new CargarDTO();

    @PostMapping("register")
    public void registerUser(@RequestBody UsuarioDto body) {
        usuarioService.save(body);
    }

    @PostMapping("login")
    public ResponseEntity<?> checkLogin(@RequestBody Map<String, String> body) {
        UsuarioDto userDto = cargarDTO.userDTO(authService.checkLogin(body.get("email"), body.get("password")));

        if (userDto == null) {
            return new ResponseEntity<>("No existe el registro", HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
