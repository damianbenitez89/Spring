package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    @Autowired // hace que UsuarioDaoImplemente cree un objeto y la guarde en la variable usario Dao
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)// metodo POST para insertar  en base de datos
    public String login(@RequestBody Usuario usuario) { // con esto el JSON que recibe lo convierte en usuario automaticamente

        if (usuarioDao.verificarCredenciales(usuario)){
            return "OK";
        }
        return "FAIL";


    }

}
