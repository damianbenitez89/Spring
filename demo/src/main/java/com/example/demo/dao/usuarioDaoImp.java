package com.example.demo.dao;

import com.example.demo.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public class usuarioDaoImp implements usuarioDao {

    @Override
    public List<Usuario> getUsuarios() {
        return null;
    }
}
