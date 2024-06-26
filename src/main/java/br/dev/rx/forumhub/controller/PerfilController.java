package br.dev.rx.forumhub.controller;

import br.dev.rx.forumhub.domain.perfil.DadosCadastroPerfil;
import br.dev.rx.forumhub.domain.perfil.DadosDetalhamentoPerfil;
import br.dev.rx.forumhub.domain.perfil.PerfilService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("perfis")
@SecurityRequirement(name = "bearer-key")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPerfil dados, UriComponentsBuilder uriBuilder){

        Long perfilId = perfilService.cadastrar(dados);
        var uri = uriBuilder.path("/perfis/{id}").buildAndExpand(perfilId).toUri();

        return ResponseEntity.created(uri).body("Perfil registrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoPerfil>> listar(Pageable pageable){
        Page<DadosDetalhamentoPerfil> perfilPage = perfilService.getAllPerfis(pageable);
        return ResponseEntity.ok(perfilPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody DadosDetalhamentoPerfil dados){
        perfilService.atualizar(id,dados);
        return ResponseEntity.ok("Perfil atualizado com sucesso!");
    }
}
