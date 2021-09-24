package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(23165L);
        usuario.setApellido("benitez");
        usuario.setNombre("Damian");
        usuario.setEmail("benitez@gmail.com");
        usuario.setTelefono("1141764794");
        usuario.setPassword("35081213a");

        Usuario usuario2 = new Usuario();
        usuario2.setId(54165L);
        usuario2.setApellido("doamto");
        usuario2.setNombre("camila");
        usuario2.setEmail("camila@gmail.com");
        usuario2.setTelefono("12385845");
        usuario2.setPassword("35081213a");

        Usuario usuario3 = new Usuario();
        usuario3.setId(9865L);
        usuario3.setApellido("pastrana");
        usuario3.setNombre("mercedes");
        usuario3.setEmail("mechita@gmail.com");
        usuario3.setTelefono("115935558");
        usuario3.setPassword("35081213a");

        Usuario usuario4 = new Usuario();
        usuario4.setId(23985L);
        usuario4.setApellido("benitez");
        usuario4.setNombre("natalia");
        usuario4.setEmail("naty@gmail.com");
        usuario4.setTelefono("1559803130");
        usuario4.setPassword("35081213a");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);


        return usuarios;
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
