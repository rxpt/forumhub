package br.dev.rx.forumhub.domain.topico;

import br.dev.rx.forumhub.domain.usuario.DadosDetalhamentoUsuario;
import br.dev.rx.forumhub.domain.curso.DadosDetalhamentoCurso;

public record DadosListagemTopico(Long id,
                                  String titulo,
                                  String mensagem,
                                  DadosDetalhamentoUsuario autor,
                                  DadosDetalhamentoCurso curso,
                                  Boolean status
) {}
