package br.dev.rx.forumhub.domain.topico;

import br.dev.rx.forumhub.domain.usuario.DadosDetalhamentoUsuario;
import br.dev.rx.forumhub.domain.curso.DadosDetalhamentoCurso;

public record DadosDetalhamentoTopicoAtivo(
        Long id,
        String titulo,
        String mensagem,
        DadosDetalhamentoUsuario autor,
        DadosDetalhamentoCurso curso) {

    public DadosDetalhamentoTopicoAtivo(
            Long id,
            String titulo,
            String mensagem,
            DadosDetalhamentoUsuario autor,
            DadosDetalhamentoCurso curso) {

        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }
}