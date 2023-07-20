package com.matheus.intranetcaer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.intranetcaer.entities.Usuario;
import com.matheus.intranetcaer.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repositorio;

    // selecione um usuário do banco de dados com base no ID.
    public Usuario achePorId(Integer id){
        try {
            Optional<Usuario> obj = repositorio.findById(id);
            return obj.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }   

    // seleciona todos os usuários presentes no banco de dados.
    public List<Usuario> acheTodos(){
        return repositorio.findAll();
    }

    // apagar
    public Boolean apagar(Integer id){
        try {
            Usuario obj = repositorio.getReferenceById(id);
            if (obj != null){ // verifica se o cara está no banco de dados
                repositorio.delete(obj);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // salvar
    public Usuario salvar(Usuario obj){
        try {
            if (obj == null){
                return null;
            } else {
                return repositorio.save(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // alterar
    public Usuario alterar(Integer id, Usuario outro){
        Usuario obj = achePorId(id);
        alterarDados(obj, outro);
        try {
            return repositorio.save(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // alterar dados
    private void alterarDados(Usuario obj, Usuario outro){
        obj.setEmail(outro.getEmail());
        obj.setNome(outro.getNome());
        obj.setSenha(outro.getSenha());
    } 
}
