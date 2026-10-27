package br.com.etechoracio.clubelivro.service;

import br.com.etechoracio.clubelivro.entity.Livro;
import br.com.etechoracio.clubelivro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    public LivroRepository livroRepository;

    public List<Livro> getAll()
    {
        List<Livro> livros = livroRepository.findAll();
        return livros;
    }
}
