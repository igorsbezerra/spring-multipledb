package com.example.multipledatabase.service;

import com.example.multipledatabase.model.app.Livro;

import java.util.List;

public interface LivroService {

    List<Livro> obterLivros();
    Livro criar(Livro livro);
}
