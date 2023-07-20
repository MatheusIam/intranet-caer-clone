package com.matheus.intranetcaer.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.intranetcaer.entities.Usuario;
import com.matheus.intranetcaer.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosRC {
    @Autowired
    private UsuarioService service;

    // obter todos os usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> obterTodos(){
        List<Usuario> usuarios = service.acheTodos();
        return ResponseEntity.ok().body(usuarios);
    }

    
}
