package com.example.multipledatabase.service.impl;

import com.example.multipledatabase.model.app.Livro;
import com.example.multipledatabase.model.auth.Usuario;
import com.example.multipledatabase.repository.app.LivroRepository;
import com.example.multipledatabase.repository.auth.UsuarioRepository;
import com.example.multipledatabase.service.LivroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    final LivroRepository livroRepository;
    final UsuarioRepository usuarioRepository;

    public LivroServiceImpl(LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Livro> obterLivros() {
        return this.livroRepository.findAll();
    }

    @Override
    public Livro criar(Livro livro) {
        Usuario usuario = this.usuarioRepository.findById(livro.getCodigoUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        livro.setNomeUsuario(usuario.getNome());
        return this.livroRepository.save(livro);
    }
}
