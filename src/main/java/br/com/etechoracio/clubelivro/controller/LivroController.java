package br.com.etechoracio.clubelivro.controller;

import br.com.etechoracio.clubelivro.entity.Livro;
import br.com.etechoracio.clubelivro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAll()
    {
        List<Livro> livros = livroService.getAll();

        return ResponseEntity.ok(livros);
    }

    // TODO Fazer enum StatusEnum
}
