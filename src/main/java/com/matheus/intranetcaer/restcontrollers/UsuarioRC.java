package com.matheus.intranetcaer.restcontrollers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.intranetcaer.entities.Usuario;
import com.matheus.intranetcaer.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRC {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> obterUsuario(@PathVariable Integer id) {
        Usuario obj = service.achePorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/verificar")
    public ResponseEntity<Usuario> verificaLogin(@RequestBody String nome) {

        Usuario obj = service.achePorNome(nome);
        System.out.println(obj);

        if (obj != null){
            System.out.println(obj.toString());
            return ResponseEntity.ok().body(obj);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario entity) {
        entity = service.salvar(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Integer id) {

        Boolean testa = service.apagar(id);
        if (testa) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> alterar(@PathVariable Integer id, @RequestBody Usuario obj) {
        service.alterar(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
