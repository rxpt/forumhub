package br.dev.rx.forumhub.domain.topico;

import br.dev.rx.forumhub.domain.usuario.DadosDetalhamentoUsuario;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        DadosDetalhamentoUsuario autor,
        @NotBlank String nomeCurso) {
}
