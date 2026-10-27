package br.com.etechoracio.clubelivro.repository;

import br.com.etechoracio.clubelivro.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
