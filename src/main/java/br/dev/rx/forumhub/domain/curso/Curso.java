package br.dev.rx.forumhub.domain.curso;

import br.dev.rx.forumhub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table(name= "cursos")
@Entity(name = "Curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos = new ArrayList<>();
}