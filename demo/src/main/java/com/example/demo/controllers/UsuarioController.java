package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setApellido("benitez");
        usuario.setNombre("Damian");
        usuario.setEmail("benitez@gmail.com");
        usuario.setTelefono("1141764794");
        usuario.setPassword("35081213a");
        return usuario;
    }

    @RequestMapping(value = "usuario1")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("benitez");
        usuario.setNombre("Damian");
        usuario.setEmail("benitez@gmail.com");
        usuario.setTelefono("1141764794");
        usuario.setPassword("35081213a");
        return usuario;
    }

    @RequestMapping(value = "usuario2")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("benitez");
        usuario.setNombre("Damian");
        usuario.setEmail("benitez@gmail.com");
        usuario.setTelefono("1141764794");
        usuario.setPassword("35081213a");
        return usuario;
    }

    @RequestMapping(value = "usuario3")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("benitez");
        usuario.setNombre("Damian");
        usuario.setEmail("benitez@gmail.com");
        usuario.setTelefono("1141764794");
        usuario.setPassword("35081213a");
        return usuario;
    }
}
