package br.com.claro.catalogo.dados.util;

import br.com.claro.catalogo.dados.service.LdapService;
import br.com.claro.catalogo.dados.vo.TokenDataVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author jefferson farias
 */
@Component
public class JwtTokenUtil {

    public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 15;

    @Value("$jwt.secret")
    private String secret;
    
    
    @Autowired
    @Qualifier("ldapService")
    private LdapService ldapService;

    public TokenDataVo getTokenInformation(String token) {
        Claims body = getAllClaimsFromToken(token);

        TokenDataVo data = new TokenDataVo();
        data.setLdap(body.getSubject());
        data.setRoles(this.generateUserRole((String) body.get("role")));

        return data;
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        for (GrantedAuthority role : userDetails.getAuthorities()){
            claims.put("role", role.getAuthority());
        }

        return doGenerateToken(claims, userDetails.getUsername());
    }

    //Cria o token e devine tempo de expiração pra ele
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    
    public Set<GrantedAuthority> generateUserRole(String role){
        Set<GrantedAuthority> authorities = new HashSet<>();
        
        authorities.add(new SimpleGrantedAuthority(role));
        
        return authorities;
    }

}
