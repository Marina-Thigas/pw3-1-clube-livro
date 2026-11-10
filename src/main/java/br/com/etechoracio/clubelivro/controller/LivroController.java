package br.com.etechoracio.clubelivro.controller;

import br.com.etechoracio.clubelivro.entity.Livro;
import br.com.etechoracio.clubelivro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id)
    {
        Livro livro = livroService.findById(id);
        if(livro == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro)
    {
        Livro livroCadastrado = livroService.cadastrar(livro);
        return ResponseEntity.ok(livroCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Map<String, Object> mapaCampoValor){
        Livro livro = livroService.atualizar(id, mapaCampoValor);
        if (livro == null)
            return ResponseEntity.notFound().build();
        else if(livro.getId() == -1)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> deletar(@PathVariable Long id)
    {
        Livro livroDeletado = livroService.deletar(id);
        if(!(livroDeletado == null))
            return ResponseEntity.ok(livroDeletado);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/emprestar")
    public ResponseEntity<Livro> emprestar(@PathVariable Long id)
    {
        Livro livroEmprestado = livroService.emprestar(id);
        if(livroEmprestado == null)
            return ResponseEntity.notFound().build();
        else if (livroEmprestado.getId() == -1) {
            return ResponseEntity.badRequest().build();
        }
        else
            return ResponseEntity.ok(livroEmprestado);
    }

    @PostMapping("/{id}/devolver")
    public ResponseEntity<Livro> devolver(@PathVariable Long id)
    {
        Livro livroDevolvido = livroService.devolver(id);

        if(livroDevolvido == null)
            return ResponseEntity.notFound().build();
        else if (livroDevolvido.getId() == -1)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(livroDevolvido);

    }
}
