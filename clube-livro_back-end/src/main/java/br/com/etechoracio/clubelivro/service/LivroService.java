package br.com.etechoracio.clubelivro.service;

import br.com.etechoracio.clubelivro.entity.Livro;
import br.com.etechoracio.clubelivro.enums.StatusEnum;
import br.com.etechoracio.clubelivro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    public LivroRepository livroRepository;

    public List<Livro> getAll()
    {
        return livroRepository.findAll();
    }

    public Livro findById(Long id)
    {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent())
            return livroOptional.get();
        else
            return null;
    }

    public Livro cadastrar(Livro livro)
    {
        livro.setStatus(StatusEnum.DISPONIVEL);

        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Map<String, Object> mapaCampoValor)
    {
        Optional<Livro> livro = livroRepository.findById(id);

        if(!livro.isPresent())
            return null;
        else {
            Livro livroAtualizado = livro.get();

            mapaCampoValor.forEach( (campo, valor) -> {
                if (campo.equals("titulo"))
                    livroAtualizado.setTitulo(valor.toString());
                else if (campo.equals("status"))
                {
                    if(valor.toString().toLowerCase().equals("disponivel"))
                        livroAtualizado.setStatus(StatusEnum.DISPONIVEL);
                    else if(valor.toString().toLowerCase().equals("emprestado"))
                        livroAtualizado.setStatus(StatusEnum.EMPRESTADO);
                    else
                        livroAtualizado.setId(Long.parseLong("-1"));
                }
                else if (campo.equals("dono"))
                    livroAtualizado.setDono(valor.toString());
                    // else if (campo.equals("dataEmprestimo"))
                    //     livroAtualizado.setDataEmprestimo((LocalDateTime)valor);
                else if (campo.equals("dataDevolucaoPrevista"))
                    livroAtualizado.setDataDevolucaoPrevista(LocalDateTime.parse(valor.toString()));
                else
                    livroAtualizado.setId(Long.parseLong("-1"));
            } );
            if (livroAtualizado.getId() == -1)
                return livroAtualizado;
            return livroRepository.save(livroAtualizado);
        }
    }

    public Livro deletar(Long id)
    {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if(optionalLivro.isPresent())
        {
            Livro livro = optionalLivro.get();
            livroRepository.delete(livro);
            return livro;
        }
        else
            return null;
    }

    public Livro emprestar(Long id)
    {
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if(!optionalLivro.isPresent())
            return null;
        else
        {
            Livro livro = optionalLivro.get();

            if(livro.getStatus() == StatusEnum.EMPRESTADO)
            {
                livro.setId(Long.parseLong("-1"));
                return livro;
            }

            livro.setStatus(StatusEnum.EMPRESTADO);
            livro.setDataEmprestimo(LocalDateTime.now());
            livro.setDataDevolucaoPrevista(LocalDateTime.now().plusDays(7));

            return livroRepository.save(livro);
        }
    }

    public Livro devolver(Long id)
    {
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if(optionalLivro.isEmpty())
            return null;
        else
        {
            Livro livro = optionalLivro.get();

            if(livro.getStatus() == StatusEnum.EMPRESTADO) {
                livro.setStatus(StatusEnum.DISPONIVEL);
                livro.setDataDevolucaoPrevista(null);
                livro.setDataEmprestimo(null);
                return livroRepository.save(livro);
            }
            else {
                livro.setId(Long.parseLong("-1"));
                return livro;
            }

        }
    }

}
