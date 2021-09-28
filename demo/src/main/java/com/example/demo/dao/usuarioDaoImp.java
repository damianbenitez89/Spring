package com.example.demo.dao;

import com.example.demo.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //hace referencia a la conexion de base de datos
@Transactional //le da funcion de generar la consulta de sql

public class usuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager; //nos va  aservir para la conexion a la base de datos

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {

        String query ="FROM Usuario";
        List <Usuario> resultado = entityManager.createQuery(query).getResultList();
        return (resultado);
    }
}
