package com.example.demo.dao;

import com.example.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query ="FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())

                .getResultList();

        if(lista.isEmpty()){//si la lista esta vacia retornar falso
            return null;
        }

        String passwoerdHasheada = lista.get(0).getPassword(); // con esta linea obntengo las pass de la base de datos del email solicitido;

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);//creo una variable de tipo argon2 para poder usar sus funciones y verificar
        if(argon2.verify(passwoerdHasheada,usuario.getPassword())){
            return lista.get(0);
        };//comparo la pass que tipearon con la pass hasheada de la base de datos

        return null;


    }
}
