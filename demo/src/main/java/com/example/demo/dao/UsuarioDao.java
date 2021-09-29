package com.example.demo.dao;

import com.example.demo.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(long id);

    void registrar(Usuario usuario);
}
