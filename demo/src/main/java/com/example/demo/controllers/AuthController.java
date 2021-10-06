package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import com.example.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    @Autowired // hace que UsuarioDaoImplemente cree un objeto y la guarde en la variable usario Dao
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)// metodo POST para insertar  en base de datos
    public String login(@RequestBody Usuario usuario) { // con esto el JSON que recibe lo convierte en usuario automaticamente

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario); //la verificacion del usuario la ponemos en una variable

        if (usuarioLogueado!=null){ //

            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail()); //con estos 2 datos nos genera el token, y vamos a devolver el JWT asginado en una variable

            return tokenJwt; // con esto ya creamos el toker
        }
        return "FAIL";


    }

}
