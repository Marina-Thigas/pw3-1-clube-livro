package br.com.etechoracio.clubelivro.entity;


import br.com.etechoracio.clubelivro.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import java.time.LocalDateTime;

@Table(name = "Livro")
@Entity
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String dono;

    @Enumerated(EnumType.STRING)
    @Column(name="estatus")
    private StatusEnum status;

    private LocalDateTime dataEmprestimo;

    private LocalDateTime dataDevolucaoPrevista;
}
