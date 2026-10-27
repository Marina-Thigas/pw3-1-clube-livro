package br.com.etechoracio.clubelivro.entity;


import jakarta.persistence.*;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import java.time.LocalDateTime;

@Entity
@Table(name = "Livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String dono;

    @Column(name="estatus")
    private String status;

    private LocalDateTime dataEmprestimo;

    private LocalDateTime dataDevolucaoPrevista;
}
