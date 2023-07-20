package com.matheus.intranetcaer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheus.intranetcaer.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
