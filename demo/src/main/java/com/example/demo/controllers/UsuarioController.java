package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;


import com.example.demo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// LOS CONTROLADORES SON PARA MANEJAR LAS URL BASICAMENTE


@RestController
public class UsuarioController {

    @Autowired // hace que UsuarioDaoImplemente cree un objeto y la guarde en la variable usario Dao
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)// INDICA EN LA URL DEL CONTENIDO EN ESTE CASO LOCALHOST:8080/USUARIOS
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token){ // como parametro le vamos a pasar la autorizacion y lo vamos poner en una variable token

        String usuarioId = jwtUtil.getKey(token);
                if(usuarioId==null){
                    return new ArrayList<>();
                }
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)// metodo POST para insertar  en base de datos
    public void registrarUsuario(@RequestBody Usuario usuario){ // con la anotacion esto el JSON que recibe lo convierte en usuario automaticamente

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id); //creacion de variable para generar el hasheo
        String hash = argon2.hash(1,1024,1,usuario.getPassword()); // el dato que dese hashear, iteraciones, memoria , paralellismo y password
        usuario.setPassword(hash); // aca enviamos la contraceña hasheada
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id ){ //no va a devolver nada
        usuarioDao.eliminar(id);
    }

}
