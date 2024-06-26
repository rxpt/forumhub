package br.dev.rx.forumhub.domain.topico;

import br.dev.rx.forumhub.domain.resposta.DadosDetalhamentoResposta;
import br.dev.rx.forumhub.domain.usuario.DadosDetalhamentoUsuario;
import br.dev.rx.forumhub.domain.curso.DadosDetalhamentoCurso;

import java.util.List;

public record DadosDetalhamentoTopico(Long id,
                                      String titulo,
                                      String mensagem,
                                      DadosDetalhamentoUsuario autor,
                                      DadosDetalhamentoCurso curso,
                                      List<DadosDetalhamentoResposta> resposta,
                                      Boolean status
) {}
