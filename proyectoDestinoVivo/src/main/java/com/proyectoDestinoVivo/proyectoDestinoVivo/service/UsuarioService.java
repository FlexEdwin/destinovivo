package com.proyectoDestinoVivo.proyectoDestinoVivo.service;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario insertarUsuario(Usuario usuario){
        try {
            return usuarioRepository.save(usuario);
        }catch (DataAccessException e){
            throw new RuntimeException("Error al insertar el usuario" +e);
        }
    }

    public Usuario editarUsuario(int documento, Usuario usuario){
        Usuario existente = usuarioRepository.findById(documento).orElseThrow(()->new RuntimeException("Empresa no existente"));
        existente.setNombre(usuario.getNombre());
        existente.setCorreo(usuario.getCorreo());
        existente.setTelefono(usuario.getTelefono());
        existente.setNacionalidad(usuario.getNacionalidad());
        existente.setFecha_nacimiento(usuario.getFecha_nacimiento());
        return usuarioRepository.save(existente);
    }

    public String eliminarUsuario(int documento){
        Usuario existente = usuarioRepository.findById(documento).orElseThrow(()->new RuntimeException("Empresa no existente"));
        usuarioRepository.deleteById(existente.getDocumento());
        return "Usuario eliminado correctamente";
    }


    public List<Usuario> consultarUsuario(){
        return usuarioRepository.findAll();
    }
}
