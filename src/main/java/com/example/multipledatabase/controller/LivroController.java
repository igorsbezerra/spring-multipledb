package com.example.multipledatabase.controller;

import com.example.multipledatabase.model.app.Livro;
import com.example.multipledatabase.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> obterLivros() {
        return this.livroService.obterLivros();
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.livroService.criar(livro));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
