package br.dev.rx.forumhub.domain.usuario;

public record DadosDetalhamentoUsuario(
        Long id,
        String nome,
        String login,
        Boolean status) {}
