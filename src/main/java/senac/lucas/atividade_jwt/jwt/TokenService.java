package senac.lucas.atividade_jwt.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import senac.lucas.atividade_jwt.modelos.Usuario;

import java.util.Date;

@Service
public class TokenService {
    private String secret = "teste_api_seguranca";
    private String withIssuer = "cadastros-api";

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Date expiresAt = new Date(System.currentTimeMillis() + (1000 * 60 * 60));
            String tokenJwt = JWT.create()
                    .withIssuer(withIssuer)
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(expiresAt)
                    .sign(algorithm);
            return tokenJwt;
        } catch (Exception e){
            throw new RuntimeException("Erro na geração de token!");
        }
    }

    public String validarToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String subject = JWT.require(algorithm)
                    .withIssuer(withIssuer)
                    .build()
                    .verify(token)
                    .getSubject();
            return subject;
        } catch (Exception e) {
            return null;
        }
    }
}
