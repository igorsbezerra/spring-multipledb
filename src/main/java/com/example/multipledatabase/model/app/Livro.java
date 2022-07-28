package com.example.multipledatabase.model.app;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    private Long codigo;
    private String titulo;
    private String author;
    private String tema;
    @Column(name = "nome_usuario")
    private String nomeUsuario;
    @Transient
    private Long codigoUsuario;
}
