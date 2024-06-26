package br.dev.rx.forumhub.domain.resposta;

import br.dev.rx.forumhub.domain.topico.Topico;
import br.dev.rx.forumhub.domain.topico.TopicoService;
import br.dev.rx.forumhub.domain.usuario.Usuario;
import br.dev.rx.forumhub.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private UsuarioService usuarioService;

    public Usuario findByLogin(String login){
        return usuarioService.findByLogin(login);
    }

    @Transactional
    public void cadastrar(Long topicoId, DadosCadastroResposta dados, Usuario autor, LocalDateTime dataCriacao){

        Topico topico = topicoService.findById(topicoId);

        if (topico.getStatus()){
            Resposta resposta = dados.toEntity(autor,topico,dataCriacao);
            repository.save(resposta);
        } else {
            throw new IllegalArgumentException("Tópico inativo. Resposta não foi salva");
        }
    }
}
