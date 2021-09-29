package com.example.demo.dao;

import com.example.demo.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //hace referencia a la conexion de base de datos
@Transactional //le da funcion de generar la consulta de sql

public class usuarioDaoImp implements UsuarioDao { // clases que te implemente metodos para funciones de UsuarioDao

    @PersistenceContext
    private EntityManager entityManager; //nos va  aservir para la conexion a la base de datos

    @Override
    @Transactional
    public List<Usuario> getUsuarios() { //metodo para listar usuadios

        String query ="FROM Usuario";
        List <Usuario> resultado = entityManager.createQuery(query).getResultList(); // lista los datos de la base de dato y lo cuarda y en la variable
        return (resultado);
    }

    @Override
    public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class, id); // con esta funcion seleccion el usuario  que voy a eliminar
        entityManager.remove(usuario); // con esta funcion eliminamos

    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
}
