package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
    // getter y setter puestos con la libreria lombok
    @Getter @Setter @Column(name= "nombre")
    private String nombre;

    @Getter @Setter @Column(name= "apellido")
    private String apellido;

    @Getter @Setter @Column(name= "email")
    private String email;

    @Getter @Setter @Column(name= "telefono")
    private String telefono;

    @Getter @Setter @Column(name= "pass")
    private String password;

    @Getter @Setter @Column(name= "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)//este nos permirte que se auto complete el ID en la base de datos a la hora de registrar
    @Id
    private Long id;

}
