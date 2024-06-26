package br.dev.rx.forumhub.infra.security.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import br.dev.rx.forumhub.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Value("${api.security.token.expiration}")
    private String expiration;

    @Value("${api.security.token.issuer}")
    private String issuer;

    public String gerarToken(Usuario usuario) throws JWTCreationException {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer(issuer)
                .withSubject(usuario.getUsername())
                .withIssuedAt(Instant.now())
                .withClaim("username", usuario.getUsername())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);
    }

    public String getSubject(String tokenJWT) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.require(algorithm)
                .withIssuer(issuer)
                .build()
                .verify(tokenJWT)
                .getSubject();
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusSeconds(Long.parseLong(expiration)).toInstant(ZoneOffset.of("-03:00"));
    }
}
