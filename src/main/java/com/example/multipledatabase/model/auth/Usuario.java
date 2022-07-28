package com.example.multipledatabase.model.auth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private Long codigo;
    private String nome;
    private String email;
    private String senha;
}
